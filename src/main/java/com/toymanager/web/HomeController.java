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
import dto.Cart;
import dto.Item;
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
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author DucTien Nhiệm vụ duy nhất của controller là 1. Để trả về đúng view
 * người dùng sẽ nhận (url nào) 2. Trả kết qu cho người dùng trong single pages
 * như kiểm tra tính đúng dữ liệu
 */
@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat", "/dang-ky"})
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
                case "signup":{
                    String alert = request.getParameter("alert");

                    if (message != null && alert != null) {
                        request.setAttribute("message", resourceBundle.getString(message));
                        request.setAttribute("alert", alert);
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("/view/web/signup.jsp");
                    rd.forward(request, response);
                    break;
                }
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
                case "addcart": {
                    try {
                        Long id = Long.parseLong(request.getParameter("id"));
                        Toy toy = (Toy) toyService.findById(id);
                        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
                        if (cart == null) {
                            cart = new Cart();
                        }
                        if (cart.getCartItems().containsKey(id)) {
                            cart.plusToCart(id, new Item(toy, cart.getCartItems().get(id).getQuantity()));
                        } else {
                            cart.plusToCart(id, new Item(toy, 1));
                        }
                        SessionUtil.getInstance().putValue(request, SystemConstant.CART, cart);

                        response.sendRedirect(request.getContextPath() + "/trang-chu");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        response.sendRedirect(request.getContextPath() + "/trang-chu");
                    }
                    break;
                }
                case "removecart": {
                    try {
                        Long id = Long.parseLong(request.getParameter("id"));
                        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
                        if (cart == null) {
                            cart = new Cart();
                        }
                        if (cart.getCartItems().containsKey(id)) {
                            cart.removeToCart(id);
                        }
                        SessionUtil.getInstance().putValue(request, SystemConstant.CART, cart);

                        response.sendRedirect(request.getContextPath() + "/trang-chu");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        response.sendRedirect(request.getContextPath() + "/trang-chu");
                    }
                    break;
                }
                default: {
                    RequestDispatcher rd = request.getRequestDispatcher("/view/web/home.jsp");
                    rd.forward(request, response);
                }
            }
        } else {
            directHomePage(request, response);
        }

    }

    private void directHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //New toys
        Toy newToys = new Toy();
        Sorter sort = new Sorter("name", "desc");
        Pageble pageble = new PageRequest(1, 5, sort);
        newToys.setListResult(toyService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_NEW_TOYS, newToys);

        //Top seller
        Toy sellerToys = new Toy();
        sort = new Sorter("price", "desc");
        pageble = new PageRequest(1, 5, sort);
        sellerToys.setListResult(toyService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_SELLER_TOYS, sellerToys);

        //Top seller
        Toy seller3Toy = new Toy();
        sort = new Sorter("price", "desc");
        pageble = new PageRequest(1, 3, sort);
        seller3Toy.setListResult(toyService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_3SELLER_TOYS, seller3Toy);

        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
        if(cart!=null){
            request.setAttribute(SystemConstant.CART, cart);
        }

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
                if (priority == 1) {
                    response.sendRedirect(request.getContextPath() + "/trang-chu");
                } else
                    if (model.getRole().getPriority() > 1) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        }
        if(action!=null && action.equals("signup")){
                User model = FormUtil.toModel(User.class, request);
                model.setRoleId((long) 1);
                User result = (User) userService.save(model);
                if (result != null) {
                    response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=signup_success&alert=success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/dang-ky?action=signup&message=wrong_infor&alert=danger");
                }
        }

    }
}
