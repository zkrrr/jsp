<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-1
  Time: 上午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="square" class="org.Square" scope="page">
    <jsp:setProperty name="square" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>show</title>
</head>
<body>
<%
    out.println("正方形的边长为：" + square.getD());
    out.println("正方形的周长为：" + square.getC());
    out.println("正方形的面积为：" + square.getS());
%>
</body>
</html>
