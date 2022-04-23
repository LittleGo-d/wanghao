package com.wh.controller; /**
 * @author whstart
 * @creat 2022-${MOTH}-21-17:53
 */

import com.wh.bean.User;
import com.wh.service.UserService;
import com.wh.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String id = request.getParameter("id");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setId(Integer.parseInt(id));
        System.out.println(user);

        userService.update(user);
        request.getRequestDispatcher("/userInf.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
