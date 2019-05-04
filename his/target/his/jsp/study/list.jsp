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
                location.href="${path}/jsp/study/add.jsp";
             })
            $(".update").click(function () { 
                var sId = $(this).attr("name");
                location.href="${path}/study/load.action?sId="+sId;
             })
            $(".delete").click(function () { 
                var sId = $(this).attr("name");
                location.href="${path}/study/delete.action?sId="+sId;
             })
            $("#search").click(function () { 
                var sName = $("#sName").val();
                location.href = "${path}/study/search.action?sName="+sName;
             })
            $("#div1").dblclick(function () {
                $.get("${path}/doctorVisitRecord/ajaxListss.action",function (data) {
                    var $div1 = $("#div1");
                    $(data).each(function () {
                        var $span = $("<span>"+this.basePatientInfo.patientName+"</span><br/>");
                        $span.appendTo($div1);
                    });
                },"json");
            });
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            学生姓名：<input type="text" id="sName" value="${searchObject.SName}">
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
            <td>学生姓名</td> 
            <td>性别</td> 
            <td>年龄</td> 
            <td>地址</td>
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="study" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${study.SName}</td>
                <td>${study.SSex}</td>
                <td>${study.SAge}</td>
                <td>${study.site.MSite}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${study.SId}"></td>
                <td><img src="${path}/images/del.gif" class="delete" name="${study.SId}"></td>
            </tr> 
        </c:forEach> 
    </table>

    <div id="div1" style="border: 1px crimson solid;width: 200px;height: 200px;">

    </div>
</body> 
</html> 
