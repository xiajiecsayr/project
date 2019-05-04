<%-- 
  Created by IntelliJ IDEA. 
  2018/12/05 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/companyinfo/add.jsp";
             })
            $(".update").click(function () { 
                var cid = $(this).attr("name");
                location.href="${path}/companyinfo/load.action?cid="+cid;
             })
            $(".delete").click(function () { 
                var cid = $(this).attr("name");
                location.href="${path}/companyinfo/delete.action?cid="+cid;
             });
            $("#search").click(function () { 
                var compname = $("#compname").val();
                var ownername = $("#ownername").val();
                location.href = "${path}/companyinfo/search.action?compname="+compname+"&ownername="+ownername;
             });
            /*$("#find").click(function () {
             var cid = $(this).attr("name");
             location.href="{path}/telvisit/lists.action?cid="+cid;
             });*/
            $("#visit").click(function () {
                var cid = $(":checked").val();
                if(!cid){
                    alert("请选择一家公司");
                    return false;
                }
                location.href="${path}/jsp/telvisit/add.jsp?cid="+cid;
            });
        })  
    </script> 
</head> 
<body class="main">
<center><h3>客户信息资源列表</h3></center>
    <div class="search">
        <button id="visit">添加回访记录</button>
        <span> 
            公司名称：<input type="text" id="compname" value="${searchObject.compname}"> 
        </span>
        <span>
            法人姓名：<input type="text" id="ownername" value="${searchObject.ownername}">
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
            <td>选择</td>
            <td>序号</td>
            <td>公司名称</td> 
            <td>法人姓名</td> 
            <td>法人电话</td> 
            <td>公司简介</td> 
            <td>操作</td>
        </thead> 
        <c:forEach items="${list}" var="companyinfo" varStatus="status"> 
            <tr id="trs">
                <td><input type="radio" name="aa" value="${companyinfo.cid}"></td>
                <td>${status.index+1}</td>
                <td>${companyinfo.compname}</td> 
                <td>${companyinfo.ownername}</td> 
                <td>${companyinfo.ownertel}</td> 
                <td>${companyinfo.compinfo}</td> 
                <td><a id="find" href="${path}/telvisit/lists.action?cid=${companyinfo.cid}">查看所有回访</a></td>
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
