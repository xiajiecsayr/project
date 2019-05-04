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
<h1>修改功能</h1>
<form action="${path}/baseFunction/update.action">
    <input type="hidden" name="fid" value="${baseFunction1.fid}">
    <div class="update">
        <div class="left">
            <span>功能名称</span>
            <input type="text" name="fname" value="${baseFunction1.fname}">
        </div>
        <div class="right">
            <span>管理名称</span>
            <select id="se" name="mid">
                <c:forEach items="${list}" var="str">
                    <option value="${str.mid}">${str.mname}</option>
                </c:forEach>
            </select>
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
