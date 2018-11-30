<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-10-29
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doLogin</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username.equals("admin")&&password.equals("123")){
        session.setAttribute("name",username);
        response.sendRedirect("messageBoard.jsp");
    }
    else {
        response.sendError(500,"用户名或者密码错误!!");
    }
%>
</body>
</html>
