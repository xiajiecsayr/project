<%@ page import="com.qhit.baseUser.pojo.BaseUser" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/3 0003
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>

</head>

<body class="main">
<h1>修改管理</h1>
<form action="${path}/baseMoudule/update.action">
    <input type="hidden" name="mid" value="${baseModules.mid}">
    <div class="update">
        <div class="left">
            <span>管理名称</span>
            <input type="text" name="mname" value="${baseModules.mname}">
        </div>
        <div class="right">

        </div>
        <div class="left">

        </div>
        <div class="right">

        </div>
        <div id="error"></div>
        <div class="buttons">
            <input type="submit" value="提交">
            <input type="button" onclick="history.back()" value="返回">
        </div>
    </div>
</form>
</body>

</html>
