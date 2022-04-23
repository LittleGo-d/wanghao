<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2022/4/21
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>
<h1>LOGIN</h1>
    <form action="<%=request.getContextPath()%>/login">
        <div id="errorMsg">${login_msg}${register_msg}</div>
        username:<input id="name" name="name" value="${cookie.name.value}" type="text"><br>
        password:<input id="password" name="password" value="${cookie.password.value}" type="text"><br>
        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <input type="submit" value="SUBM IT">
    </form>
</body>
</html>
