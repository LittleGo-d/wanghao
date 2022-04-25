package com.wh.controller;

import com.wh.dao.UserDao;
import com.wh.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        /// TODO 1: GET 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        // TODO 2: GET JDBC connection
        //only one one
        con = (Connection) getServletContext().getAttribute("con");
        //check the video live demo#4
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost(request,response);//call dopost
        //when user click Login from menu- method is get
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        // TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        String username=request.getParameter("username");
        String password=request.getParameter("password");


        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);
            if(user!=null){

//                Cookie c=new Cookie("sessionid",""+user.getId());
//                c.setMaxAge(10+60);
//                response.addCookie(c);

                String remeberMe=request.getParameter("remeberMe");
                if(remeberMe!=null && remeberMe.equals("1")){
                    Cookie usernameCookice=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookice=new Cookie("cPassword",user.getPassword());
                    Cookie rememberCookice=new Cookie("cRemember",remeberMe);

                    usernameCookice.setMaxAge(5);
                    passwordCookice.setMaxAge(5);
                    rememberCookice.setMaxAge(5);

                    response.addCookie(usernameCookice);
                    response.addCookie(passwordCookice);
                    response.addCookie(rememberCookice);
                }

                HttpSession session = request.getSession();
                System.out.println("sessionid-->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                request.setAttribute("user",user);

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
