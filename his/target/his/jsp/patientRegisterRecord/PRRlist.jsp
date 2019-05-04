<%--
  Created by IntelliJ IDEA. 
  2018/12/22 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/patientRegisterRecord/add.jsp";
             })
            $(".update").click(function () { 
                var registerId = $(this).attr("name");
                location.href="${path}/patientRegisterRecord/load.action?registerId="+registerId;
             })
            $(".delete").click(function () { 
                var registerId = $(this).attr("name");
                location.href="${path}/patientRegisterRecord/delete.action?registerId="+registerId;
             })
            $("#search").click(function () { 
                var patientName = $("#patientName").val();
                location.href = "${path}/basePatientInfo/searchs.action?patientName="+patientName;
             })
            //医生
            $.get("${path}/baseUser/listAS.action",function (data) {
                var $se1 = $(".se1");
                $(data).each(function () {
                    var $open = $("<option value='"+this.uid+"'>"+this.baseUser.cname+"</option>");
                    $open.appendTo($se1);
                })
            },"json")
            //科室
            $.get("${path}/baseDept/ajaxList.action",function (data) {
                var $se2 = $(".se2");
                $(data).each(function () {
                    var $open = $("<option value='"+this.deptId+"'>"+this.deptName+"</option>");
                    $open.appendTo($se2);
                })
            },"json");
            //选择科室后显示该科室医生
            $("table tr").each(function () {
                var thistr=$(this);

                $(this).find("td .se2").change(function () {
                    var $keshi = thistr.find("td .se2").val();//科室的id
                    thistr.find("td .se1").hide();//没选科室时的医生
                    thistr.find("td .se3").show();//选择科室时的医生
                    $.get("${path}/baseUser/$keshi.action",{$keshi:$keshi},function (data) {
                        var $se3 = thistr.find("td .se3");
                        var $op = thistr.find("td .se3 option");
                        $op.remove();
                    $(data).each(function () {
                        var $ope=$("<option value=''>---请选择要挂在这个科室下的哪位医生下---</option>");
                        var $open = $("<option value='"+this.userId+"'>"+this.cname+"</option>");
                        $ope.appendTo($se3);
                        $open.appendTo($se3);
                    });
                    if(!data){
                        var $ope=$("<option value=''>---该科室下暂时没有医生---</option>");
                        $ope.appendTo($se3);
                    }
                    },"json");

                });
            });
            //确认提交
            $("table tr").each(function () {
                var thistr=$(this);
                $(this).find("td .confirm").click(function () {
                    var keshi=thistr.find("td .se2").val();
                    if(keshi=="" || keshi==null){
                        var yisheng=thistr.find("td .se1").val();//没选择科室时的医生
                    }else {
                        var yisheng=thistr.find("td .se3").val();//选择科室时的医生
                    }
                    var bingren=thistr.find(".inp1").val();
                    if((keshi=="" ||keshi==null) && (yisheng=="" ||yisheng=="")){
                        alert("请选择挂号对象！")
                    }else {
                        $.get("${path}/patientRegisterRecord/ajaxListS.action",{bingren:bingren},function (data) {
                            if(data){
                                alert("该病人已挂号！！！")
                            }else {
                                location.href="${path}/patientRegisterRecord/insertS.action?yisheng="+yisheng+"&keshi="+keshi+"&bingren="+bingren;
                            }
                        },"json");
                    }
                });
            });
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            病人：<input type="text" id="patientName" value="${searchObject.patientName}">
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
            <td>病人</td>
            <td>挂号科室</td>
            <td>挂号医生</td>
            <td>操作</td>
        </thead> 
        <c:forEach items="${list}" var="patientRegisterRecord" varStatus="status"> 
            <tr>
                <input type="hidden" value="${patientRegisterRecord.patientId}" class="inp1"><%--病人id--%>
                <td>${status.index+1}</td> 
                <td>${patientRegisterRecord.patientName}</td>
                <td>
                    <select class="se2">
                        <option value="">---请选择要挂在哪个科室下---</option>
                    </select>
                </td>
                <td>
                    <select class="se1">
                        <option value="">---请选择要挂在哪位医生下---</option>
                    </select>
                    <select class="se3" style="display: none;">
                        <option value="">---请选择要挂在这个科室下的哪位医生下---</option>
                    </select>
                </td>
                <td><button class="confirm">确定</button></td>
            </tr> 
        </c:forEach>
    </table>
</body>
</html> 
