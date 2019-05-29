package com.toymanager.filter;


import com.toymanager.constant.SystemConstant;
import com.toymanager.model.UserModel;
import com.toymanager.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.contains("/admin")) {
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if (model != null) {
                if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                if (model.getRole().getCode().equals(SystemConstant.USER)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_permisstion&alert=danger");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_permisstion&alert=warning");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
