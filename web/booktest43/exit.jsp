<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Exit</title>
</head>

<body>
<%session.removeAttribute("username");
    response.sendRedirect("a_login.jsp");
%>

</body>
</html>