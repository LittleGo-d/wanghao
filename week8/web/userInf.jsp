<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2022/4/21
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInf</title>
</head>
<body>
<h1>WELCOME,<%=session.getAttribute("name")%></h1>
<h2><a href="<%=request.getContextPath()%>/logout">LOGOUT</a></h2>
<h2><a href="<%=request.getContextPath()%>/update.jsp">Update</a></h2>
</body>
</html>
