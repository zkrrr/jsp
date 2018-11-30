<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<html>
<head>
    <title>My JSP 'testFilter.jsp' starting page</title>
</head>

<body>
<% session.setAttribute("username",request.getParameter("username"));%>
<form action="a_login.jsp" method="post">
    <input type="submit" value="TestLogin">
</form>
</body>
</html>