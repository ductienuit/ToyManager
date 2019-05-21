/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.web;

import com.halo.thuchanh3.model.UserModel;
import com.halo.thuchanh3.service.ICategoryService;
import com.halo.thuchanh3.service.INewService;
import com.halo.thuchanh3.service.IUserService;
import com.halo.thuchanh3.utils.FormUtil;
import com.halo.thuchanh3.utils.SessionUtil;
import dao.CategoryDAO;

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
 * @author DucTien Nhiệm vụ duy nhất của controller là 1. Để trả về đúng view
 * người dùng sẽ nhận (url nào) 2. Trả kết qu cho người dùng trong single pages
 * như kiểm tra tính đúng dữ liệu
 */
@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat", "/toy"})
public class HomeController extends HttpServlet {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newsService;

    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
//        TEST
//        RequestDispatcher xxx = request.getRequestDispatcher("/view/web/home.jsp");
//        xxx.forward(request, response);

        if (action != null && action.equals("login")) {
            String message = request.getParameter("message");
            String alert = request.getParameter("alert");

            if (message != null && alert != null) {
                request.setAttribute("message", resourceBundle.getString(message));
                request.setAttribute("alert", alert);
            }

            RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/trang-chu");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/view/web/home.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel model = FormUtil.toModel(UserModel.class, request);
            model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
            if (model != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
                if (model.getRole().getCode().equals("USER")) {
                    response.sendRedirect(request.getContextPath() + "/trang-chu");
                } else if (model.getRole().getCode().equals("ADMIN")) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
}
