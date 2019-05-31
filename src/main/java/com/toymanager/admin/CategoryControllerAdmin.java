package com.toymanager.admin;

import com.toymanager.constant.SystemConstant;
import com.toymanager.model.CategoryModel;
import com.toymanager.model.NewsModel;
import com.toymanager.model.UserModel;
import com.toymanager.paging.PageRequest;
import com.toymanager.paging.Pageble;
import com.toymanager.service.ICategoryService;
import com.toymanager.service.IToyService;
import com.toymanager.sort.Sorter;
import com.toymanager.utils.FormUtil;
import com.toymanager.utils.SessionUtil;
import dao.CategoryDAO;

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
@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryControllerAdmin extends HttpServlet {

    @Inject
    private IToyService newsService;

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //Thay vì dùng request.getParameter từng giá trị thì mình dùng
        //FormUtil để mapping với model của mình
        NewsModel model = FormUtil.toModel(NewsModel.class, request);
        Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);

        model.setListResult(newsService.findAll(pageble));
        model.setTotalItem(newsService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/category/list.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("insert")) {
            CategoryModel model = FormUtil.toModel(CategoryModel.class, request);
//            model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
//            if (model != null) {
//                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
//                if (model.getRole().getCode().equals("USER")) {
//                    response.sendRedirect(request.getContextPath() + "/trang-chu");
//                } else if (model.getRole().getCode().equals("ADMIN")) {
//                    response.sendRedirect(request.getContextPath() + "/admin-home");
//                }
//            } else {
//                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
//            }
            response.sendRedirect(request.getContextPath() + "/admin-home");
        }
        response.sendRedirect(request.getContextPath() + "/admin-home");
    }
}
