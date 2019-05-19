/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.admin;

import com.halo.thuchanh3.constant.SystemConstant;
import com.halo.thuchanh3.model.NewsModel;
import com.halo.thuchanh3.service.INewService;
import com.halo.thuchanh3.utils.FormUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DucTien
 */
@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {

    @Inject
    private INewService newsService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        NewsModel model = FormUtil.toModel(NewsModel.class, request);

        Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
//        model.setLis
        model.setListResult(newsService.findAll(offset, model.getMaxPageItem(), model.getSortName(), model.getSortBy()));
        model.setTotalItem(newsService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/news/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
