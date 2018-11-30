<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-10-29
  Time: 下午2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="DoLogin.jsp">
    <table align="center">
        <tr>
            <td>
                用户名:
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                密码:
            </td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="Submit" value="提交">
            </td>
            <td>
                <input type="reset" name="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
