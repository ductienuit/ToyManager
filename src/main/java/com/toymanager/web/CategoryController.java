/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.web;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.ICategoryService;
import com.toymanager.service.IToyService;
import com.toymanager.service.IUserService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.SessionUtil;
import dto.Cart;
import dto.Category;
import dto.Item;
import dto.Toy;

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

    @Inject
    private IUserService userService;

    @Inject
    private IToyService toyService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String message = request.getParameter("category");
        String alert = request.getParameter("alert");
        String productid = request.getParameter("sanpham");
        String quantity = request.getParameter("quantity");

        if (message != null && alert != null) {
            request.setAttribute("category", resourceBundle.getString(message));
        }

        //Thêm xóa sửa giỏ hàng
        if(quantity != null){
            ProcessCart(request,response,action);
        }
        //Show chi tiết sản phẩm và danh sách sản phẩm
        else if (productid != null && !productid.equals("")) {
            DirectProduct(request,response,productid);

            RequestDispatcher rd = request.getRequestDispatcher("/view/web/product.jsp");

            rd.forward(request, response);
        } else {
            DirectCategory(request,response);

            RequestDispatcher rd = request.getRequestDispatcher("/view/web/category.jsp");
            rd.forward(request, response);
        }
    }

    private void ProcessCart(HttpServletRequest request, HttpServletResponse response, String action) throws IOException {
        if(action!=null)
        switch (action){
            case "addcart": {
                try {
                    Long id = Long.parseLong(request.getParameter("sanpham"));
                    Integer quantity = Integer.parseInt(request.getParameter("quantity"));

                    Toy toy = (Toy) toyService.findById(id);
                    Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
                    if (cart == null) {
                        cart = new Cart();
                    }
                    if (cart.getCartItems().containsKey(id)) {
                        cart.plusToCart(id, new Item(toy, cart.getCartItems().get(id).getQuantity()+quantity-1));
                    } else {
                        cart.plusToCart(id, new Item(toy, quantity));
                    }
                    SessionUtil.getInstance().putValue(request, SystemConstant.CART, cart);
                    response.sendRedirect(request.getContextPath() + "/danh-muc");
                } catch (Exception e) {
                    System.out.println(e.toString());
                    response.sendRedirect(request.getContextPath() + "/danh-muc");
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
                    response.sendRedirect(request.getContextPath() + "/danh-muc");

                } catch (Exception e) {
                    System.out.println(e.toString());
                    response.sendRedirect(request.getContextPath() + "/danh-muc");
                }
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void DirectCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //New toys
        Toy newToys = new Toy();
        Sorter sort = new Sorter("name", "desc");
        Pageble pageble = new PageRequest(1, 10, sort);
        newToys.setListResult(toyService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_NEW_TOYS, newToys);

        Category category = new Category();
        category.setListResult(categoryService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_CATEGORY, category);

        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
        if(cart!=null){
            request.setAttribute(SystemConstant.CART, cart);
        }
    }

    private void DirectProduct(HttpServletRequest request, HttpServletResponse response, String productid) throws ServletException, IOException {
        //Top seller
        Toy sellerToys = new Toy();
        Sorter sort = new Sorter("name", "desc");
        Pageble pageble = new PageRequest(1, 4, sort);
        sellerToys.setListResult(toyService.findAll(pageble));
        request.setAttribute(SystemConstant.MODEL_SELLER_TOYS, sellerToys);

        Long id = Long.parseLong(productid);
        Toy model = (Toy) toyService.findById(id);
        request.setAttribute(SystemConstant.MODEL, model);

        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
        if(cart!=null){
            request.setAttribute(SystemConstant.CART, cart);
        }
    }

}
