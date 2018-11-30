<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test11</title>
</head>
<body>
<%
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    String time = simpleDateFormat.format(date);
    out.println("This is "+time+"<br>");
%>
<%
    int hour = date.getHours();
    if(hour>=1&&hour<=12){
        out.println("Good Morning");
    }
    else if(hour>12&&hour<=18){
        out.println("Good Afternoon");
    }
    else
        out.println("Good evening");
%>
</body>
</html>
