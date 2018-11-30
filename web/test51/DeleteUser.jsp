<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-2
  Time: 下午1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteUser</title>
</head>
<body>
<div align="center">
    <B>删除用户</B>
</div>
<form action="DeleteUser" method="post">
    <table align="center">
        <tr>
            <td>
                输入删除的用户名:
            </td>
            <td>
                <input type="text" name="username" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="删除用户">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
