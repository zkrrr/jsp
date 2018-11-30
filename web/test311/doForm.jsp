<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-1
  Time: 上午10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="page" class="org.User">
    <jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>foForm</title>
</head>
<body>
用户名:<jsp:getProperty name="user" property="username"/>
密码:<jsp:getProperty name="user" property="pwd"/>
</body>
</html>
