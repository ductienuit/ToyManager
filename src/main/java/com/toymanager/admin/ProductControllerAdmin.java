/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IToyService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import dto.Toy;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DucTien
 */
@WebServlet(urlPatterns = {"/admin-products"})
public class ProductControllerAdmin extends HttpServlet {

    @Inject
    private IToyService toyService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        Toy model = FormUtil.toModel(Toy.class, request);
        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(toyService.findAll(pageble));
        int totalItem = toyService.getTotalItem();
        model.setTotalItem(totalItem);
        model.setTotalPage((int) Math.ceil((double) totalItem / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/products/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
