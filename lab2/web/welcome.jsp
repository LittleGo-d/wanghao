<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1><span>2020211001000626-WangHao</span></h1>
<h2>Welcome,
    <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>
    <jsp:useBean id="user" class="com.wh.lab2.Login" scope="request"></jsp:useBean>
    <%--todo 10 : use jsp:getProperty to display username --%>
    <jsp:getProperty name="user" property="username"/>

    <%
        System.out.println("WangHaoFilter--->before chain");
        System.out.println("WangHaoFilter--->after chain");
        System.out.println("WangHaoFilter--->before chain");
        System.out.println("WangHaoFilter--->after chain");
    %>
</h2>
</body>
</html>
