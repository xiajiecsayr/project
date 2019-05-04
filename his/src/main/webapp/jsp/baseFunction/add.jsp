<%--
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
    <style>
        span{
            display: inline-block;
            width: 30%;
        }
        input[type='text'],input[type='datetime']{
            margin-top: 10px;
        }
    </style>
</head>

<body class="main">
    <h1>添加功能</h1>
    <form action="${path}/baseFunction/insert.action">
        <div class="update">
            <div class="left">
                <span>功能名称</span>
                <input type="text" name="fname" id="fname">
            </div>
            <div class="right">
                <span>模块名称</span>
                <select id="se" name="mname">
                    <option></option>
                    <c:forEach items="${list}" var="str">
                        <option value="${str.mname}">${str.mname}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="left">
                <span>url</span>
                <input type="text" name="url" id="url">
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
