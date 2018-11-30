<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-11-18
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="dao.Jdbc"%>
<%@ page import="java.sql.SQLException" %>
<%
    String username=request.getParameter("queryName");
    domain.User user=new domain.User();
    if(username!=null&&username!="")
    {
        Jdbc dbUser=new Jdbc();
        domain.User temp= null;
        try {
            temp = dbUser.searchByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(temp==null)
        {
            out.print("用户名不存在！");
        }
        else
            user=temp;//防止user为null，导致下文的user.getUsername()产生异常
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form name="query" method="post" action="">
        <font face="宋体" size="6"><strong>查询和修改用户</strong></font><br/><hr/><br/>
        输入查询的用户名：  <input name="queryName" type="text"/> <input type="submit" name="query" value="查询用户" /><br/><br/><hr/><br/>
    </form>

    <form name="modify" method="post" action="UpdateServlet">
        用户名：
        <input name="modfyName" type="text" value="<%=user.getUsername()%>" readonly="readonly" />
        <br/><br/>
        密&nbsp;&nbsp;码：
        <input name="password" type="text" value="<%=user.getPassword()%>"/>
        <br /><br />
        <input type="submit" name="modify" value="修改用户" />
    </form>
    <hr/>
    <a href="DeleteUser.jsp">删除用户</a><br/>
    <a href="AddUser.jsp">添加用户</a><br/>
</div>
</body>
</html>
