package com.toymanager.admin;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.toymanager.constant.SystemConstant;
import com.toymanager.model.CategoryModel;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.ICategoryService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import dao.impl.CategoryDAO;
import dto.Category;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author DucTien
 */
@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryControllerAdmin extends HttpServlet {

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        String action = request.getParameter("type");
        Category model = FormUtil.toModel(Category.class, request);
        if (action != null) {
            switch (action) {
                case "edit": {
                    model = (Category) categoryService.findById(model.getId());
                    request.setAttribute(SystemConstant.MODEL, model);
                    RequestDispatcher rd = request.getRequestDispatcher("/view/admin/category/edit.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "delete": {
                    categoryService.delete(model.getId());
                    model = (Category) categoryService.findById(model.getId());
                    StringBuilder redirect = new StringBuilder(request.getContextPath());
                    redirect.append("/admin-category?type=list&page=1&maxPageItem=4&sortName=title&sortBy=asc");

                    if (model == null) {
                        redirect.append("&message=delete_sucess&alert=success");
                    } else {
                        redirect.append("&message=fail_process&alert=danger");
                    }
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

    private void directList(HttpServletRequest request, HttpServletResponse response, Category model) throws ServletException, IOException {
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");

        if (message != null && alert != null) {
            request.setAttribute("message", resourceBundle.getString(message));
            request.setAttribute("alert", alert);
        }

        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(categoryService.findAll(pageble));
        int totalItem = categoryService.getTotalItem();
        model.setTotalItem(totalItem);
        model.setTotalPage((int) Math.ceil((double) totalItem / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/category/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        StringBuilder redirect = new StringBuilder(request.getContextPath());
        redirect.append("/admin-category?type=list&page=1&maxPageItem=4&sortName=title&sortBy=asc");
        String action = request.getParameter("command");
        switch (action) {
            case "insert": {
                Category model = FormUtil.toModel(Category.class, request);
                Category result = (Category) categoryService.save(model);
                if (result != null) {
                    redirect.append("&message=add_sucess&alert=success");
                } else {
                    redirect.append("&message=fail_process&alert=danger");
                }
                break;
            }
            case "edit": {
                Category model = FormUtil.toModel(Category.class, request);
                Category result = (Category) categoryService.update(model);
                if (result != null) {
                    redirect.append("&message=edit_sucess&alert=success");
                } else {
                    redirect.append("&message=fail_process&alert=danger");
                }
                break;
            }
        }
        response.sendRedirect(redirect.toString());
    }
}
