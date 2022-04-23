package com.wh.controller; /**
 * @author whstart
 * @creat 2022-${MOTH}-21-17:36
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).invalidate();
        request.setAttribute("login_msg","You have seccessfully logged out!");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
