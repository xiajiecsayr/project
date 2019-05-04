<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2018/11/5
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form enctype="multipart/form-data" method="post" action="${path}/wenjian">
        <input type="file" name="${nameProp}" multiple="multiple">
        <input type="submit" value="提交">
    </form>
</body>
</html>
