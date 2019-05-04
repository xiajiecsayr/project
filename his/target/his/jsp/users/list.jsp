<%-- 
  Created by IntelliJ IDEA. 
  2018/12/20 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head>
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/users/add.jsp";
             })
            $(".update").click(function () { 
                var uid = $(this).attr("name");
                location.href="${path}/users/load.action?uid="+uid;
             })
            $(".delete").click(function () { 
                var uid = $(this).attr("name");
                location.href="${path}/users/delete.action?uid="+uid;
             })
            $("#search").click(function () { 
                var uname = $("#uname").val();
                location.href = "${path}/users/search.action?uname="+uname;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            ：<input type="text" id="uname" value="${searchObject.uname}"> 
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
            <td></td> 
            <td></td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="users" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${users.uname}</td> 
                <td>${users.pwd}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${users.uid}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${users.uid}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
