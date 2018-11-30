<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-10-29
  Time: 下午1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test13</title>
    <script>
        function check() {
            if(document.form1.username.value==""){
                window.alert("请输入用户名!");
                return false;
            }
            if(document.form1.password.value==""){
                window.alert("请输入密码!");
                return false;
            }
            if(document.form1.realname.value==""){
                window.alert("请输入真实姓名!");
                return false;
            }
            if(document.form1.sex.value==""){
                window.alert("请输入性别!");
                return false;
            }
            if(document.form1.age.value==""){
                window.alert("请输入年龄!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="" method="post" name="form1" onsubmit="return check()">
<table width="409" border="1" align="center">
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
        <td>
            真实姓名:
        </td>
        <td>
            <input type="text" name="realname"/>
        </td>
    </tr>
    <tr>
        <td>
            性别:
        </td>
        <td>
            <input type="radio" name="sex" value="男" checked="checked"/>男
            <input type="radio" name="sex" value="女"/>女
        </td>
    </tr>
    <tr>
        <td>
            年龄:
        </td>
        <td>
            <input type="text" name="age"/>
        </td>
    </tr>
</table>
    <div align="center">
        <input type="submit" name="Submit" value="注册">
        <input type="reset" name="Reset" value="重置">
    </div>
</form>
</body>
</html>
