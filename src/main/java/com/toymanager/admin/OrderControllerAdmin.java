package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IOrderService;
import com.toymanager.service.IOrderService;
import com.toymanager.service.IToyService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import dto.Order;
import dto.Order;
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

@WebServlet(urlPatterns = {"/admin-order"})
public class OrderControllerAdmin extends HttpServlet {

    @Inject
    private IOrderService orderService;

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        String action = request.getParameter("type");
        Order model = FormUtil.toModel(Order.class, request);
        if (action != null) {
            switch (action) {
                case "detail": {
                    model = (Order) orderService.findById(model.getId());
                    request.setAttribute(SystemConstant.MODEL, model);
                    RequestDispatcher rd = request.getRequestDispatcher("/view/admin/orders/detail.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "list": {
                    directList(request, response, model);
                    break;
                }
            }
        } else {
            directList(request, response, model);
        }

    }

    private void directList(HttpServletRequest request, HttpServletResponse response, Order model) throws ServletException, IOException {
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");

        if (message != null && alert != null) {
            request.setAttribute("message", resourceBundle.getString(message));
            request.setAttribute("alert", alert);
        }

        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(orderService.findAll(pageble));
        int totalItem = orderService.getTotalItem();
        model.setTotalItem(totalItem);
        model.setTotalPage((int) Math.ceil((double) totalItem / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/orders/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        StringBuilder redirect = new StringBuilder(request.getContextPath());
        redirect.append("/admin-order?type=list&page=1&maxPageItem=4&sortName=orderDate&sortBy=asc");
        String action = request.getParameter("command");
        switch (action) {
            case "insert": {
                Order model = FormUtil.toModel(Order.class, request);
                Order result = (Order) orderService.save(model);
                if (result != null) {
                    redirect.append("&message=add_sucess&alert=success");
                } else {
                    redirect.append("&message=fail_process&alert=danger");
                }
                break;
            }
            case "edit": {
                Order model = FormUtil.toModel(Order.class, request);
                Order result = (Order) orderService.update(model);
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
