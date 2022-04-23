package com.wh.controller; /**
 * @author whstart
 * @creat 2022-${MOTH}-21-16:30
 */

import com.wh.bean.User;
import com.wh.service.UserService;
import com.wh.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = userService.login(name, password);
        if(user != null){
            int id = user.getId();
            String idStr = id + "";
            //登陆成功
            //判断是否勾选复选框remember
            String remember = request.getParameter("remember");
            if("1".equals(remember)){
                //勾选了
                Cookie c_username = new Cookie("name",name);
                Cookie c_password = new Cookie("password",password);
                Cookie c_id = new Cookie("id",idStr);

                c_username.setMaxAge(60 * 60 * 24 *7);
                c_password.setMaxAge(60 * 60 * 24 *7);
                c_id.setMaxAge(60 * 60 * 24 *7);

                response.addCookie(c_username);
                response.addCookie(c_password);
                response.addCookie(c_id);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("name",name);
            session.setAttribute("id",idStr);

            response.sendRedirect(request.getContextPath() + "/userInf.jsp");
        }else{
            //登陆失败

            request.setAttribute("login_msg","The user name or password is incorrect!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
