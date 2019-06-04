package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IOrderService;
import com.toymanager.service.IToyService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
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

@WebServlet(urlPatterns = {"/admin-order"})
public class OrderControllerAdmin extends HttpServlet {

    @Inject
    private IOrderService orderService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        Order model = FormUtil.toModel(Order.class, request);
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

    }
}
