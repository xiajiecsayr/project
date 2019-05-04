<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2018/12/2
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>角色管理</title>
    <script>
        $(function () {
            //授权
            $(".distribute").click(function () {
                var rid = $(this).attr("name");
                location.href="${path}/baseRole/distributeLoad.action?rid="+rid;
            });
        })
    </script>
</head>
<body class="main">
    <div class="search">
            <span>
                角色：<input type="text" id="cname" value="${searchObject.cname}">
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
        <td>角色</td>
        <td>修改</td>
        <td>删除</td>
        <td>授权</td>
        </thead>
        <c:forEach items="${list}" var="baseRole" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${baseRole.rname}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${baseRole.rid}"></td>
                <td><img src="${path}/images/del.gif" class="delete" name="${baseRole.rid}"></td>
                <td><img src="${path}/images/distribute.gif" class="distribute" name="${baseRole.rid}"></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
