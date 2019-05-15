/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.web;

import com.halo.thuchanh3.model.NewsModel;
import com.halo.thuchanh3.service.ICategoryService;
import com.halo.thuchanh3.service.INewService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DucTien Nhiệm vụ duy nhất của controller là 1. Để trả về đúng view
 * người dùng sẽ nhận (url nào) 2. Trả kết qu cho người dùng trong single pages
 * như kiểm tra tính đúng dữ liệu
 */
@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newsService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Long categoryId = 1L;
        //request.setAttribute("news", newsService.findByCategoryId(categoryId));

        //request.setAttribute("categories", categoryService.findAll());
        String title = "Bài viết 5";
        String content = "Đồ chơi cho trẻ con, đẹp khỏe ....";
        Long categoryId = 1L;
        NewsModel news = new NewsModel();
        news.setTitle(title);
        news.setContent(content);
        news.setCategoryId(categoryId);
        newsService.save(news);

        RequestDispatcher rd = request.getRequestDispatcher("/view/web/home.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
