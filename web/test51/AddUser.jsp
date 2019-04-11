<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-2
  Time: 下午1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUser</title>
</head>
<body>
<div align="center">
    <B>添加用户</B>
</div>
<form action="AddUser" method="post">
    <table align="center">
        <tr>
            <td>
                用户名:
            </td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td>
                密码:
            </td>
            <td>
                <input type="text" name="password"/>
            </td>
        </tr>
        <tr>
            <td >
                <input type="submit" value="提交">
            </td>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
<div filter align="center">
<a href="SearchAndModify.jsp">查询界面</a>
</div>
<div align="center" >
<a href="DeleteUser.jsp">删除界面</a>
    </div>
</body>
</html>
