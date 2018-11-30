<%@ page import="org.User" %><%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-1
  Time: 上午10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foForm</title>
</head>
<body>
<%
    out.println("用户名:");
    String username = request.getParameter("username");
    out.println(username);
    out.println("密码:");
    String pwd = request.getParameter("pwd");
    out.println(pwd);
%>
</body>
</html>
