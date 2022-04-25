<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2022/4/21
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/update" method="post">
    id:<input id="id" name="id" value="<%=session.getAttribute("id")%>">
    name:<input id="name" name="name" value="${cookie.name.value}">
    password:<input id="password" name="password" value="${cookie.password.value}">
    <input type="submit" value="Update">
</form>
<%@ include file="footer.jsp"%>
</body>
</html>
