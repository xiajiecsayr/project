<%-- 
  Created by IntelliJ IDEA. 
  2018/12/26 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/site/add.jsp";
             })
            $(".update").click(function () { 
                var mId = $(this).attr("name");
                location.href="${path}/site/load.action?mId="+mId;
             })
            $(".delete").click(function () { 
                var mId = $(this).attr("name");
                location.href="${path}/site/delete.action?mId="+mId;
             })
            $("#search").click(function () { 
                var mSite = $("#mSite").val();
                location.href = "${path}/site/search.action?mSite="+mSite;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            地名：<input type="text" id="mSite" value="${searchObject.mSite}"> 
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
            <td>地名</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="site" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${site.mSite}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${site.mId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${site.mId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
