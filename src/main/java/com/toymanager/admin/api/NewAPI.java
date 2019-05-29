/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toymanager.model.NewsModel;
import com.toymanager.service.IToyService;
import com.toymanager.utils.HttpUtils;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DucTien
 */
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

    @Inject
    private IToyService newService;

    //Add topic
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Request tieng viet
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewsModel newsModel = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
        newsModel = newService.save(newsModel);
        System.out.print(newsModel);
        mapper.writeValue(response.getOutputStream(), newsModel);
    }

    //Update database
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Request tieng viet
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewsModel updateModel = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
        updateModel = newService.update(updateModel);
        mapper.writeValue(response.getOutputStream(), updateModel);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Request tieng viet
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        NewsModel deleteModels = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
        newService.delete(deleteModels.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }
}
