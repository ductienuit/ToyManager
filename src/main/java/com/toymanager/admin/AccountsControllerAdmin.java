package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IToyService;
import com.toymanager.service.IUserService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import dto.User;
import dto.Toy;
import dto.User;

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
@WebServlet(urlPatterns = {"/admin-accounts"})
public class AccountsControllerAdmin extends HttpServlet {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        String action = request.getParameter("type");
        User model = FormUtil.toModel(User.class, request);
        if (action != null) {
            switch (action) {
                case "insert":{
                    RequestDispatcher rd = request.getRequestDispatcher("/view/admin/accounts/add.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "edit": {
                    model = (User) userService.findById(model.getId());
                    request.setAttribute(SystemConstant.MODEL, model);
                    RequestDispatcher rd = request.getRequestDispatcher("/view/admin/accounts/edit.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "delete": {
                    userService.delete(model.getId());
                    model = (User) userService.findById(model.getId());
                    StringBuilder redirect = new StringBuilder(request.getContextPath());
                    redirect.append("/admin-accounts?type=list&page=1&maxPageItem=4&sortName=id&sortBy=asc");

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

    private void directList(HttpServletRequest request, HttpServletResponse response, User model) throws ServletException, IOException {
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");

        if (message != null && alert != null) {
            request.setAttribute("message", resourceBundle.getString(message));
            request.setAttribute("alert", alert);
        }

        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(userService.findAll(pageble));
        int totalItem = userService.getTotalItem();
        model.setTotalItem(totalItem);
        model.setTotalPage((int) Math.ceil((double) totalItem / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/accounts/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        StringBuilder redirect = new StringBuilder(request.getContextPath());
        redirect.append("/admin-accounts?type=list&page=1&maxPageItem=4&sortName=id&sortBy=asc");
        String action = request.getParameter("command");
        switch (action) {
            case "insert": {
                User model = FormUtil.toModel(User.class, request);
                User result = (User) userService.save(model);
                if (result != null) {
                    redirect.append("&message=add_sucess&alert=success");
                } else {
                    redirect.append("&message=fail_process&alert=danger");
                }
                break;
            }
            case "edit": {
                User model = FormUtil.toModel(User.class, request);
                User result = (User) userService.update(model);
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

