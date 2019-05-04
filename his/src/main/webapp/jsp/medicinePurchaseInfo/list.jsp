<%-- 
  Created by IntelliJ IDEA. 
  2018/12/06 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/medicinePurchaseInfo/add.jsp";
             })
            $(".update").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/load.action?pchId="+pchId;
             })
            $(".delete").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/delete.action?pchId="+pchId;
             })
            $("#search").click(function () { 
                var medicineCodeid = $("#medicineCodeid").val();
                location.href = "${path}/medicinePurchaseInfo/search.action?medicineCodeid="+medicineCodeid;
             })
            $("#collect").click(function () {
                $.get("${path}/medicinePurchaseInfo/ajaxList.action",function (data) {
                    if(!data){
                        alert("没有已审批的计划");
                    }else {
                        location.href = "${path}/medicinePurchaseInfo/collect.action";
                    }
                },"json");
            })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            药品：<input type="text" id="medicineCodeid" value="${searchObject.medicineCodeid}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span>
        <span>
            <button id="collect">汇总</button>
        </span>
    </div> 
    <table> 
        <thead>
            <td>序号</td> 
            <td>药品</td> 
            <td>供应商</td> 
            <td>采购数量</td> 
            <td>采购单价</td> 
            <td>采购总价</td> 
            <td>状态</td> 
            <td>汇总人</td> 
            <td>汇总日期</td> 
            <td>审批人</td> 
            <td>审批日期</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="medicinePurchaseInfo" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${medicinePurchaseInfo.medicineCode.medicineName}</td>
                <td>${medicinePurchaseInfo.medicineCode.manChnName}</td>
                <td>${medicinePurchaseInfo.pchAmt}盒</td>
                <td>${medicinePurchaseInfo.pchPrice}元</td>
                <td>${medicinePurchaseInfo.pchTotal}元</td><%--总价--%>
                <c:choose>
                    <c:when test="${medicinePurchaseInfo.status==2}">
                        <td>采购未审批</td>
                    </c:when>
                    <c:when test="${medicinePurchaseInfo.status==1}">
                        <td>采购已审批</td>
                    </c:when>
                    <c:when test="${medicinePurchaseInfo.status==3}">
                        <td>采购已入库</td>
                    </c:when>
                </c:choose>
                <td>${uame.baseUser.cname}</td>
                <td>${medicinePurchaseInfo.pchDate}</td> 
                <td>${medicinePurchaseInfo.baseUser.cname}</td>
                <td>${medicinePurchaseInfo.medicineReqPlan.apprvDate}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${medicinePurchaseInfo.pchId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${medicinePurchaseInfo.pchId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
