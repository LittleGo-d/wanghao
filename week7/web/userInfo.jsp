<%@ page import="com.wh.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2022/4/23
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%@include file="header.jsp"%>
<body>
<%
    User user=(User)request.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr><tr>
    <td>Password:</td><td><%=user.getPassword()%></td>
    </tr><tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
    </tr><tr>
        <td>Gender:</td><td><%=user.getGender()%></td>
    </tr><tr>
        <td>Birth Date:</td><td><%=user.getBirthdate()%></td>
    </tr>

</table>

<%@include file="footer.jsp"%>
</body>
</html>
