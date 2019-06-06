package com.toymanager.web;

import com.toymanager.constant.SystemConstant;
import com.toymanager.utils.SessionUtil;
import dto.Cart;

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
@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
        if(cart!=null){
            request.setAttribute(SystemConstant.CART, cart);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/web/checkout.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Check out
    }
}
