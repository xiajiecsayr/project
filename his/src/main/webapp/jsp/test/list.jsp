<%-- 
  Created by IntelliJ IDEA. 
  2018/12/24 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/test/add.jsp";
             })
            $(".update").click(function () { 
                var tId = $(this).attr("name");
                location.href="${path}/test/load.action?tId="+tId;
             })
            $(".delete").click(function () { 
                var tId = $(this).attr("name");
                location.href="${path}/test/delete.action?tId="+tId;
             })
            $("#search").click(function () { 
                var tName = $("#tName").val();
                var tSex  = $("#tSex").val();
                location.href = "${path}/test/search.action?tName="+tName+"&tSex="+tSex;
             })
            
            $("#deleteBtn").click(function () {
                var url = "${path}/test/deleteBatch.action?a=a";
                $(":checked").each(function () {
                    url+="&tId="+$(this).val();
                });
                location.href = url;
            });

        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span>
            用户名：<input type="text" id="tName" value="${searchObject.TName}">
        </span>
        <span>
            性别：<input type="text" id="tSex" value="${searchObject.TSex}">
        </span>
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span>
        <span>
            <button id="deleteBtn">批量删除</button>
        </span>
    </div> 
    <table> 
        <thead>
            <td></td>
            <td>序号</td> 
            <td>用户名</td> 
            <td>性别</td> 
            <td>年龄</td>
            <td>解释</td>
            <td>地址</td>
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="test" varStatus="status"> 
            <tr>
                <td><input type="checkbox" value="${test.TId}"></td>
                <td>${status.index+1}</td> 
                <td>${test.TName}</td>
                <td>${test.TSex}</td>
                <td>${test.TAge}</td>
                <td>${test.decipher}</td>
                <td>${test.test1.AName}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${test.TId}"></td>
                <td><img src="${path}/images/del.gif" class="delete" name="${test.TId}"></td>
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
