<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-10-29
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>messageBoard</title>
</head>
<body>
<form action="showMessage.jsp">
    <table align="center">
        <tr>
            <td>
                留言标题:
            </td>
            <td>
                <input type="text" name="title">
            </td>
        </tr>
        <tr>
            <td>
                留言内容:
            </td>
            <td>
                <textarea rows="5" name="text" id="text"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="Submit" value="提交">
            </td>
            <td>
                <input type="reset" name="Reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
