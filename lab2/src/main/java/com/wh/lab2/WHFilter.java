package com.wh.lab2;

import javax.servlet.*;
import java.io.IOException;

public class WHFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("WangHaoFilter--->before chain");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("WangHaoFilter--->after chain");
    }

    @Override
    public void destroy() {

    }
}
