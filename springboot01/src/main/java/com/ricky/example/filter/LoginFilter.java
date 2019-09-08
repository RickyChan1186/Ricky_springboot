package com.ricky.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ricky
 * @create 2019-09-04 20:02
 */
//@WebFilter(urlPatterns = "/api/filter/*",filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String username = httpServletRequest.getParameter("username");
        if("ricky".equals(username)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            httpServletResponse.sendRedirect("/upload.html");
            return;
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter");
    }
}
