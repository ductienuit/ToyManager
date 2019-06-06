/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.ICategoryService;
import com.toymanager.service.IToyService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import dto.Toy;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author DucTien
 */
@WebServlet(urlPatterns = {"/admin-products"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProductControllerAdmin extends HttpServlet {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Inject
    private IToyService toyService;

    @Inject
    private ICategoryService categoryService;

    String command="";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        String action = request.getParameter("type");
        Toy model = FormUtil.toModel(Toy.class, request);
        if (action != null) {
            switch (action) {
                case "insert": {
                    request.setAttribute(SystemConstant.LIST, categoryService.findAll());
                    RequestDispatcher rd = request.getRequestDispatcher("/view/admin/products/add.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "edit": {
                    model = (Toy) toyService.findById(model.getId());
                    request.setAttribute(SystemConstant.MODEL, model);
                    request.setAttribute(SystemConstant.LIST, categoryService.findAll());
                    RequestDispatcher rd = request.getRequestDispatcher("/view/admin/products/edit.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "delete": {
                    toyService.delete(model.getId());
                    model = (Toy) toyService.findById(model.getId());
                    StringBuilder redirect = new StringBuilder(request.getContextPath());
                    redirect.append("/admin-products?type=list&page=1&maxPageItem=4&sortName=id&sortBy=asc");

                    if (model == null) {
                        redirect.append("&message=delete_sucess&alert=success");
                    } else {
                        redirect.append("&message=fail_process&alert=danger");
                    }
                    response.sendRedirect(redirect.toString());
                    break;
                }
                default: {
                    directList(request, response, model);
                }
            }
        } else {
            directList(request, response, model);
        }

    }

    private void directList(HttpServletRequest request, HttpServletResponse response, Toy model) throws ServletException, IOException {
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");

        if (message != null && alert != null) {
            request.setAttribute("message", resourceBundle.getString(message));
            request.setAttribute("alert", alert);
        }

        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(toyService.findAll(pageble));
        int totalItem = toyService.getTotalItem();
        model.setTotalItem(totalItem);
        model.setTotalPage((int) Math.ceil((double) totalItem / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/products/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StringBuilder redirect = new StringBuilder(request.getContextPath());
        redirect.append("/admin-products?type=list&page=1&maxPageItem=4&sortName=id&sortBy=asc");
        String action = "insert";//request.getParameter("command");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if(isMultipart){
            Toy model = parseModel(request,response, redirect);
            switch (command){
                case "insert":{
                    Toy result = (Toy) toyService.save(model);
                    if (result != null) {
                        redirect.append("&message=add_sucess&alert=success");
                    } else {
                        redirect.append("&message=fail_process&alert=danger");
                    }
                    break;
                }
                case "edit":{
                    Toy result = (Toy) toyService.update(model);
                    if (result != null) {
                        redirect.append("&message=edit_sucess&alert=success");
                    } else {
                        redirect.append("&message=fail_process&alert=danger");
                    }
                    break;
                }
            }

        }
        response.sendRedirect(redirect.toString());
    }

    private Toy parseModel(HttpServletRequest request, HttpServletResponse response, StringBuilder redirect) throws IOException {
        ServletFileUpload upload = initServletUpload();
        String uploadPath = getServletContext().getRealPath("")
                + SystemConstant.UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        List<FileItem> formItems;
        Toy model = new Toy();
        try {
            formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        model.setImageUri(fileName);
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                    }else{
                        String name = item.getFieldName();
                        switch (name){
                            case "id":{
                                model.setId(Long.parseLong(item.getString()));
                                break;
                            }
                            case "name":{
                                model.setName(item.getString());
                                break;
                            }
                            case "idCategory":{
                                model.setIdCategory(Long.parseLong(item.getString()));
                                break;
                            }
                            case "price":{
                                model.setPrice(Long.parseLong(item.getString()));
                                break;
                            }
                            case "description":{
                                model.setDescription(item.getString());
                                break;
                            }
                            case "idToyStatus":{
                                model.setIdToyStatus(Long.parseLong(item.getString()));
                                break;
                            }
                            case "command":{
                                this.command = item.getString();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirect.append("&message=fail_process&alert=danger");
            response.sendRedirect(redirect.toString());
        }
        return model;
    }

    private ServletFileUpload initServletUpload() {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(SystemConstant.MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(SystemConstant.MAX_FILE_SIZE);
        upload.setSizeMax(SystemConstant.MAX_REQUEST_SIZE);
        return upload;
    }
}
