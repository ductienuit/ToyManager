/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.admin.api;

import com.halo.thuchanh3.model.NewsModel;
import com.halo.thuchanh3.service.INewService;
import com.halo.thuchanh3.utils.HttpUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DucTien
 */
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

    @Inject
    private INewService newService;

    //Add topic
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Request tieng viet
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewsModel newsModel = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
        newsModel = newService.save(newsModel);
        System.out.print(newsModel);
    }

    //Update database
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
