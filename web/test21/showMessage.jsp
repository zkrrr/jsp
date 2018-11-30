<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 18-10-29
  Time: 下午3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="message" class="org.Message" scope="request">
    <jsp:setProperty name="message" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>showMessage</title>
</head>
<body>
<%
    out.println("留言者:"+session.getAttribute("name")+"<br>");
//    out.println("留言标题:"+request.getParameter("messageTitle")+"<br>");
//    out.println("留言内容:"+request.getParameter("messageText")+"<br>");
    out.println("留言标题:"+message.getTitle()+"<br>");
    out.println("留言内容:"+message.getText()+"<br>");
%>
</body>
</html>
