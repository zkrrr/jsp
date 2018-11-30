<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-10-29
  Time: 下午4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<jsp:useBean id="userInfo" scope="request" class="org.UserInfo"/>
<jsp:setProperty name="userInfo" property="*"/>
<body>
<table width="409" border="1">
    <tr>
        <td>用户名：</td>
        <td><%=userInfo.getUsername()%></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><%=userInfo.getPassword()%></td>
    </tr>
    <tr>
        <td>确认：</td>
        <td><%=userInfo.getRepassword()%></td>
    </tr>
    <tr>
        <td>用户真实姓名：</td>
        <td><%=userInfo.getRealname()%></td>
    </tr>
    <tr>
        <td>性别：</td>
        <td><%=userInfo.getSex()%></td>
    </tr>
    <tr>
        <td>年龄：</td>
        <td><%=userInfo.getAge()%></td>
    </tr>
    <tr>
        <td>出生：</td>
        <td><%=userInfo.getBorn()%></td>
    </tr>
    <tr>
        <td>地址：</td>
        <td><%=userInfo.getAddress() %></td>
    </tr>
    <tr>
        <td>介绍：</td>
        <td><%=userInfo.getIntroduce() %></td>
    </tr>
</table>
</body>
</html>
