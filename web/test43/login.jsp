<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-1
  Time: 下午5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="testFilter.jsp" method="post">
        <table>
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
                    <input type="password" name="pwd">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交" name="Submit">
                </td>
                <td>
                    <input type="reset" value="重置" name="Reset">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
