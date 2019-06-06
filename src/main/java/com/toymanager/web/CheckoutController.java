package com.toymanager.web;

import com.toymanager.constant.SystemConstant;
import com.toymanager.service.IOrderService;
import com.toymanager.utils.SessionUtil;
import dto.*;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * @author DucTien Nhiệm vụ duy nhất của controller là 1. Để trả về đúng view
 * người dùng sẽ nhận (url nào) 2. Trả kết qu cho người dùng trong single pages
 * như kiểm tra tính đúng dữ liệu
 */
@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Inject
    private IOrderService orderService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
        if (cart != null) {
            request.setAttribute(SystemConstant.CART, cart);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/web/checkout.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Check out processing
        User user = (User) SessionUtil.getInstance().getValue(request, SystemConstant.USERMODEL);
        Cart cart = (Cart) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
        String checkout = request.getParameter("checkout");
        if(checkout.equals("checkout")){
            if (cart != null && user != null && cart.getCartItems().size()>0) {
                Boolean isDone = orderService.save(user, cart);
                if (isDone) {
                    cart.getCartItems().clear();
                    SessionUtil.getInstance().removeValue(request,SystemConstant.CART);
                }
            }
        }
        if(!response.isCommitted())
            response.sendRedirect(request.getContextPath() + "/trang-chu");
    }
}
