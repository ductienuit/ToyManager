package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IToyService;
import com.toymanager.service.IUserService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import dto.Toy;
import dto.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DucTien
 */
@WebServlet(urlPatterns = {"/admin-accounts"})
public class AccountsControllerAdmin extends HttpServlet {

    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        String action = request.getParameter("type");
//        switch (action){
//            case "edit":{
//                String userId = request.getParameter("id");
//                //TODO Lấy thông tin user
//            }
//            case "delete":{
//                String userId = request.getParameter("id");
//                //TODO Lấy thông tin user
//            }
//            default:{
//                response.sendRedirect(request.getContextPath() + "/admin-category?type=list&amp;page=1&amp;maxPageItem=4&amp;sortName=title&amp;sortBy=asc");
//            }
//        }
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        User model = FormUtil.toModel(User.class, request);
        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(userService.findAll(pageble));
        int totalItem = userService.getTotalItem();
        model.setTotalItem(totalItem);
        model.setTotalPage((int) Math.ceil((double) totalItem / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/accounts/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //TODO Nhận userid ở đây và get thông tin user từ phần cập nhật

        //TODO
        User user = FormUtil.toModel(User.class, request);


        System.out.println(user.toString());
    }
}

