<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-2
  Time: 下午1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SearchAndModify</title>
</head>
<body>
<div align="center">
    <B>查询和修改用户</B>
</div>
<form  action="SelectUser" method="post" name="form1">
    <table align="center">
        <tr>
            <td>
                输入查询的用户名:
            </td>
            <td>
                <input type="text" name="username">
            </td>
            <td>
                <input type="submit" value="查询用户">
            </td>
        </tr>
    </table>
</form>

<form name="form2" action="UpdateUser" method="post">
    <table align="center">
        <tr>
            <td>
                用户名:
            </td>
            <td>
                <input type="text" name="username" value="" readonly />
            </td>
        </tr>
        <tr>
            <td>
                密码:
            </td>
            <td>
                <input type="text" name="password" value=""  />
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改用户">
            </td>
        </tr>
    </table>
</form>
<div align="center">
<a href="DeleteUser.jsp">删除用户</a>
</div>
<div align="center">
<a href="AddUser.jsp">添加用户</a>
</div>
</body>
</html>
