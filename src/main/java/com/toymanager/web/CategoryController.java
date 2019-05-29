/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.web;

import com.toymanager.service.ICategoryService;

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
 * người dùng sẽ nhận (url nào) 2. Trả kết qua cho người dùng trong single pages
 * như kiểm tra tính đúng dữ liệu
 */
@WebServlet(urlPatterns = {"/danh-muc"})
public class CategoryController extends HttpServlet {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
//        TEST
//        RequestDispatcher xxx = request.getRequestDispatcher("/view/web/home.jsp");
//        xxx.forward(request, response);
        String message = request.getParameter("category");
        String alert = request.getParameter("alert");
        String productid = request.getParameter("sanpham");

        if (message != null && alert != null) {
            request.setAttribute("category", resourceBundle.getString(message));
        }
        if (productid != null) {
            RequestDispatcher rd = request.getRequestDispatcher("/view/web/product.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/view/web/category.jsp");
            rd.forward(request, response);
        }


//        if (action != null && action.equals("login")) {
//            String message = request.getParameter("message");
//            String alert = request.getParameter("alert");
//
//            if (message != null && alert != null) {
//                request.setAttribute("message", resourceBundle.getString(message));
//                request.setAttribute("alert", alert);
//            }
//
//            RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
//            rd.forward(request, response);
//        } else if (action != null && action.equals("logout")) {
//            SessionUtil.getInstance().removeValue(request, "USERMODEL");
//            response.sendRedirect(request.getContextPath() + "/trang-chu");
//        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("/view/web/home.jsp");
//            rd.forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action != null && action.equals("login")) {
//            UserModel model = FormUtil.toModel(UserModel.class, request);
//            model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
//            if (model != null) {
//                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
//                if (model.getRole().getCode().equals("USER")) {
//                    response.sendRedirect(request.getContextPath() + "/trang-chu");
//                } else if (model.getRole().getCode().equals("ADMIN")) {
//                    response.sendRedirect(request.getContextPath() + "/admin-home");
//                }
//            } else {
//                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
//            }
//        }
    }
}
