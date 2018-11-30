<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-1
  Time: 下午5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testFilter</title>
</head>
<body>
<%
    session.setAttribute("name",request.getParameter("username"));
%>
<form method="post" action="a_login.jsp">
    <input type="submit" value="测试" name="test">
</form>
</body>
</html>
