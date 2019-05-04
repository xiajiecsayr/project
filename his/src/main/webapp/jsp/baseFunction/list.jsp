<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2018/11/28
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <script>
        $(function () {
            $("#addBtn").click(function () {
                location.href="${path}/baseFunction/adds.action";
            })
            $("#search").click(function () {
                var mname = $("#mname").val();
                var fname = $("#fname").val();
                var url = $("#url").val();
                location.href = "${path}/baseFunction/search.action?mname="+mname+"&fname="+fname+"&url="+url;
            })
            $(".delete").click(function () {
                var fid = $(this).attr("name");
                location.href="${path}/baseFunction/del.action?fid="+fid;
            });
            $(".update").click(function () {
                var fid = $(this).attr("name");
                location.href="${path}/baseFunction/edit.action?fid="+fid;
            });
        })
    </script>
</head>
<body class="main">
    <div class="search">
        <span>
                功能名称：<input type="text" id="fname" value="${baseFunction.fname}">
            </span>
            <span>
                模块名称：<input type="text" id="mname" value="${baseModule.mname}">
            </span>
        <span>
                url：<input type="text" id="url" value="${baseFunction.url}">
            </span>
        <span>
                <button id="search">查询</button>
            </span>
        <span>
                <button id="addBtn">增加</button>
            </span>
    </div>
    <table>
        <thead>
        <td>序号</td>
        <td>功能名</td>
        <td>模块名</td>
        <td>url</td>
        <td>修改</td>
        <td>删除</td>
        </thead>
        <c:forEach items="${list}" var="baseFunction" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${baseFunction.fname}</td>
                <td>${baseFunction.baseModule.mname}</td>
                <td>${baseFunction.url}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${baseFunction.fid}"></td>
                <td><img src="${path}/images/del.gif" class="delete" name="${baseFunction.fid}"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
