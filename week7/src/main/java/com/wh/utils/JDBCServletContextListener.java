package com.wh.utils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @author whstart
 * @creat 2022--22-16:02
 */
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
        ServletContext context = sce.getServletContext();
        context.removeAttribute("con");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("con");
            context.setAttribute("con",conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
