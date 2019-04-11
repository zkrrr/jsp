<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 19-4-11
  Time: 下午12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <base href="<%=basePath%>">
        <title>上传页面</title>
</head> 
<body> 
<!--多文件上传，enctype="multipart/form-data"--> 
<form action="UploadServlet" method="post" enctype="multipart/form-data">
    选择文件:  <input type="file" multiple="multiple" name="file" />
    <input type="submit" value="上传"/> 
</form> 
</body> 
</html> 