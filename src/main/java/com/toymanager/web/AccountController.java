package com.toymanager.web;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.toymanager.constant.SystemConstant;
import com.toymanager.service.IOrderService;
import com.toymanager.service.IUserService;
import com.toymanager.utils.FormUtil;
import com.toymanager.utils.SessionUtil;
import dto.Order;
import dto.OrderStatus;
import dto.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/**
 * @author DucTien Nhiệm vụ duy nhất của controller là 1. Để trả về đúng view
 * người dùng sẽ nhận (url nào) 2. Trả kết qu cho người dùng trong single pages
 * như kiểm tra tính đúng dữ liệu
 */
@WebServlet(urlPatterns = {"/tai-khoan"})
public class AccountController extends HttpServlet {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Inject
    private IOrderService orderService;
    @Inject
    IUserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        User user = (User) SessionUtil.getInstance().getValue(request, "USERMODEL");
        user = (User) userService.findById(user.getId());

        List<Order> list = new ArrayList<Order>(user.getOrders());
        list.sort((d1,d2)->d2.getOrderDate().compareTo(d1.getOrderDate()));

        SessionUtil.getInstance().putValue(request, SystemConstant.ORDERLIST,list);

        RequestDispatcher rd = request.getRequestDispatcher("/view/web/account.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        User user = (User) SessionUtil.getInstance().getValue(request, "USERMODEL");
        StringBuilder redirect = new StringBuilder(request.getContextPath());

        switch (action){
            case "edit_account":{
                redirect.append("/tai-khoan");
                User old=user;
                User model = FormUtil.toModel(User.class, request);
                try{
                    if(model!=null){
                        user.setFullName(model.getFullName());
                        user.setPhoneNumber(model.getPhoneNumber());
                        user.setAddress(model.getAddress());
                        if(model.getPassword()!=null && model.getPassword()!="")
                            user.setPassword(model.getPassword());
                        userService.update(user);
                        User newUser = (User) userService.findById(user.getId());
                        SessionUtil.getInstance().putValue(request,SystemConstant.USERMODEL,newUser);
                    }
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            }
            case "deleteOrder":{
                redirect.append("/tai-khoan");
                Order model = FormUtil.toModel(Order.class, request);
                model.setOrderStatus(OrderStatus.CANCELLED);
                Order result = (Order) orderService.update(model);
                if (result != null) {
                    //Cap nhat session
                    user = (User) userService.findById(user.getId());

                    List<Order> list = new ArrayList<Order>(user.getOrders());
                    list.sort((d1,d2)->d2.getOrderDate().compareTo(d1.getOrderDate()));

                    SessionUtil.getInstance().putValue(request, SystemConstant.ORDERLIST,list);

                    User newUser = (User) userService.findById(user.getId());
                    SessionUtil.getInstance().putValue(request,SystemConstant.USERMODEL,newUser);
                    redirect.append("&message=edit_sucess&alert=success");
                } else {
                    redirect.append("&message=fail_process&alert=danger");
                }
                break;
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/web/account.jsp");
        rd.forward(request, response);
    }
}
