<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-1
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a_login</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("name");
%>
登陆成功!<%=username%>
<form method="post" action="exit.jsp">
    <input type="submit" value="登出">
</form>
</body>
</html>