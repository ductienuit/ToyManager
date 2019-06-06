/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.web;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IToyService;
import com.toymanager.service.IUserService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import com.toymanager.utils.SessionUtil;
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
 * @author DucTien Nhiệm vụ duy nhất của controller là 1. Để trả về đúng view
 * người dùng sẽ nhận (url nào) 2. Trả kết qu cho người dùng trong single pages
 * như kiểm tra tính đúng dữ liệu
 */
@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");


    @Inject
    private IUserService userService;

    @Inject
    private IToyService toyService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String message = request.getParameter("message");

        if (action != null) {
            switch (action) {
                case "login": {
                    String alert = request.getParameter("alert");

                    if (message != null && alert != null) {
                        request.setAttribute("message", resourceBundle.getString(message));
                        request.setAttribute("alert", alert);
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "logout": {
                    SessionUtil.getInstance().removeValue(request, "USERMODEL");
                    response.sendRedirect(request.getContextPath() + "/trang-chu");
                    break;
                }
                default:{
                    //Trang chu ....

                    RequestDispatcher rd = request.getRequestDispatcher("/view/web/home.jsp");
                    rd.forward(request, response);
                }
            }
        } else {
            directHomePage(request,response);
        }

    }

    private void directHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //New toys
        Toy newToys = new Toy();
        Sorter sort = new Sorter("Name", "desc");
        Pageble pageble = new PageRequest(1 , 5, sort);
        newToys.setListResult(toyService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_NEW_TOYS, newToys);

        //Top seller
        Toy sellerToys = new Toy();
        sort = new Sorter("Price", "desc");
        pageble = new PageRequest(1 , 5, sort);
        sellerToys.setListResult(toyService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_SELLER_TOYS, sellerToys);

        RequestDispatcher rd = request.getRequestDispatcher("/view/web/home.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            User model = FormUtil.toModel(User.class, request);
            model = userService.findByUserNameAndPasswordAndStatus(model.getUsername(), model.getPassword());
            if (model != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
                int priority = model.getRole().getPriority();
                if (priority < 1) {
                    response.sendRedirect(request.getContextPath() + "/trang-chu");
                } else if (model.getRole().getPriority() >= 1) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }

}
