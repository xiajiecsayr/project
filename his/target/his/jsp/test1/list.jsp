<%-- 
  Created by IntelliJ IDEA. 
  2018/12/25 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/test1/add.jsp";
             })
            $(".update").click(function () { 
                var aId = $(this).attr("name");
                location.href="${path}/test1/load.action?aId="+aId;
             })
            $(".delete").click(function () { 
                var aId = $(this).attr("name");
                location.href="${path}/test1/delete.action?aId="+aId;
             })
            $("#search").click(function () { 
                var aName = $("#aName").val();
                location.href = "${path}/test1/search.action?aName="+aName;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            地址名：<input type="text" id="aName" value="${searchObject.aName}"> 
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
            <td>地址名</td> 
            <td>用户id</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="test1" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${test1.aName}</td> 
                <td>${test1.tId}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${test1.aId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${test1.aId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
