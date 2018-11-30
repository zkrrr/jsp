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
    User user = new User();
    request.setAttribute("users",user);
%>
<jsp:setProperty name="users" property="*"/>
用户名:<%=user.getUsername()%>
密码::<%=user.getPwd()%>
</body>
</html>
