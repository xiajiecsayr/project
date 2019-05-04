<%--
  Created by IntelliJ IDEA. 
  2018/12/28 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript">
        $(function () {
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/doctorVisitRecord/add.jsp";
             })
            $(".update").click(function () { 
                var vrId = $(this).attr("name");
                location.href="${path}/doctorVisitRecord/load.action?vrId="+vrId;
             })
            $(".delete").click(function () { 
                var vrId = $(this).attr("name");
                location.href="${path}/doctorVisitRecord/delete.action?vrId="+vrId;
             })
            $("#search").click(function () { 
                var patientId = $("#patientId").val();
                location.href = "${path}/doctorVisitRecord/search.action?patientId="+patientId;
             })
            $(".left tr .show1").click(function () {
                var pid = $(this).parent().attr("name");
                $("table .tr td").remove();
                //点击病人信息
                $.get("${path}/basePatientInfo/ajaxList.action",{pid:pid},function (data) {
                    var $tr = $(".tr");
                    $(data).each(function () {
                        var $2 = $("<td name='"+this.patientId+"'>"+this.patientName+"</td>");
                        $2.appendTo($tr);
                        var $2 = $("<td>"+this.birth+"</td>");
                        $2.appendTo($tr);
                        var $2 = $("<td>"+this.sex+"</td>");
                        $2.appendTo($tr);
                        var $2 = $("<td>"+this.address+"</td>");
                        $2.appendTo($tr);
                        var $2 = $("<td>"+this.phonenum+"</td>");
                        $2.appendTo($tr);
                        var $2 = $("<td>"+this.personid+"</td>");
                        $2.appendTo($tr);
                        var $2 = $("<td><input></td>");
                        $2.appendTo($tr);
                        var $2 = $("<td><input></td>");
                        $2.appendTo($tr);
                        var $select = $("<td><select class='select'></select></td>");
                        $select.appendTo($tr);
                        var $2 = $("<td><button>提交</button></td>");
                        $2.appendTo($tr);
                    });
                    //套餐列表
                    $.get("${path}/doctorMenu/ajaxList.action",function (data) {
                        var $select = $("#detail table .tr .select");
                        $(data).each(function () {
                            var $option = $("<option value='"+this.menuId+"'>"+this.menuName+"</option>");
                            $option.appendTo($select);
                        });
                        var $opp = $("#detail table .tr .select").val();
                        //套餐详情
                        $.get("${path}/doctorMenuMedicine/ajaxListmaintain.action",{$opp:$opp},function (data) {
                           var $medicine = $("#medicine .centre");
                           $("#medicine .centre .maintain").remove();
                            $(data).each(function () {
                                var $maintain = $("<tr class='maintain'></tr>");
                                $maintain.appendTo($medicine);
                                var $menuId = $("<td>"+this.doctorMenu.menuName+"</td>");
                                $menuId.appendTo($maintain);
                                var $codeId = $("<td>"+this.medicineCode.medicineName+"</td>");
                                $codeId.appendTo($maintain);
                                var $amt = $("<td>"+this.amt+"</td>");
                                $amt.appendTo($maintain);
                                var $img = $("<td><img src='.././images/del.gif' class='delete' name='"+this.codeId+"'></td>");
                                $img.appendTo($maintain);
                            });
                        },"json");
                        //当病人套餐变的时候显示该套餐详情
                        $("table .tr td .select").change(function () {
                            var $opp = $("#detail table .tr .select").val();
                            //套餐详情
                            $.get("${path}/doctorMenuMedicine/ajaxListmaintain.action",{$opp:$opp},function (data) {
                                var $medicine = $("#medicine .centre");
                                $("#medicine .centre .maintain").remove();
                                $(data).each(function () {
                                    var $maintain = $("<tr class='maintain'></tr>");
                                    $maintain.appendTo($medicine);
                                    var $menuId = $("<td>"+this.doctorMenu.menuName+"</td>");
                                    $menuId.appendTo($maintain);
                                    var $codeId = $("<td>"+this.medicineCode.medicineName+"</td>");
                                    $codeId.appendTo($maintain);
                                    var $amt = $("<td>"+this.amt+"</td>");
                                    $amt.appendTo($maintain);
                                    var $img = $("<td><img src='.././images/del.gif' class='delete' name='"+this.codeId+"'></td>");
                                    $img.appendTo($maintain);
                                });
                            },"json");
                        });
                    },"json");
                },"json");
                //病人信息区显示
                $("#detail").show();
                //套餐详情显示区
                $("#medicine").show();
            });
            //删除套餐详情里的药品
            $("#medicine .centre").delegate("tr td .delete","click",function () {
                alert("点击触发img");
               /* var attr = $(this).parent().parent().find(".seles").val();*/
                /*var attr = $(this).attr("name");*/
                $(this).parent().parent().remove();

            });
            //添加该套餐药品
            $("#searchs").click(function () {
                //当前套餐id
                var $opp = $("#detail table .tr .select").val();
                $.get("${path}/doctorMenu/ajaxListid.action",{$opp:$opp},function (data) {
                    var $medicine = $("#medicine .centre");//获取表位置
                $(data).each(function () {
                    var $maintain = $("<tr class='maintain'></tr>");
                    $maintain.appendTo($medicine);
                    var $td1 = $("<td>"+this.menuName+"</td>");
                    $td1.appendTo($maintain);//套餐名
                    //药品
                    $.get("${path}/medicineCode/ajaxList.action",function (data) {
                        var $select = $("<select class='seles'></select>");
                        var $td2 = $("<td></td>");
                        $td2.appendTo($maintain);//药品名称
                        $select.appendTo($td2);
                        var $td3 = $("<td><input class='in'></td>");
                        $td3.appendTo($maintain);
                        $(data).each(function () {
                            var $2 = $("<option value='"+this.codeId+"'>"+this.medicineName+"</option>");
                            $2.appendTo($select);
                        });
                        var $img = $("<td><img src='.././images/del.gif' class='delete' name='"+$(".seles").val()+"'></td>");
                        $img.appendTo($maintain);//删除符号
                        $(".seles").change(function () {
                            /*alert("药品id:"+$(this).val());*/
                           //更改这一行的img标签的name属性
                           $(this).parent().parent().find("td img").prop("name",$(".seles").val());
                        /**
                         * <a>kkkk</a>
                         */
                        });
                    },"json");
                });
                },"json");

            });
            //点击提交
            $("#detail table .tr").delegate("button","click",function () {
                var $patientId = $("#detail table .tr td:eq(0)").attr("name");//病人id
                var $inp1 = $("#detail table .tr input:eq(0)").val();//症状
                var $inp2 = $("#detail table .tr input:eq(1)").val();//嘱托
                var $inp3 = $("#detail table .tr select").val();//套餐
                var html1 = $("#medicine table .maintain td:eq(2)").html();
                alert(html1);
                var html = "";

                $("#medicine table .maintain").each(function () {//遍历tr
                    html += ($(this).find("td:eq(1) select option:selected").text()||$(this).children("td:eq(1)").text())+",";//当前tr的td
                });

                alert(html);
                alert("点击触发");
                alert("病人id"+$patientId+",症状："+$inp1+",嘱托："+$inp2+",套餐为："+$inp3);
               /* location.href="{path}/doctorVisitRecord/insertall.action?$patientId="+$patientId+"&$inp1="+$inp1+"&$inp2="+$inp2+"&$inp3="+$inp3;*/

            })
        })  
    </script>
    <style>
        .search{
            margin-left: -50px;
            width: 1280px;
            padding-left: 50px;
        }
        #medicine{
            width: 800px;
            height: 300px;
            border: 1px mediumorchid solid;
        }
        #medicine{
            background-color: cyan;
        }
    </style>
</head> 
<body class="main"> 
    <div class="search">
        <center>
        <div id="detail" style="border: 1px fuchsia solid;display: none;background-color: cyan">
            <center>病人信息显示区</center>
            <table>
                <thead>
                <td>病人姓名</td>
                <td>出生日期</td>
                <td>性别</td>
                <td>家庭住址</td>
                <td>电话号码</td>
                <td>身份证号</td>
                <td>症状</td>
                <td>医生嘱托</td>
                <td>套餐选择</td>
                <td>操作</td>
                </thead>
                    <tr class="tr">
                    </tr>
            </table>
        </div>
        </center>

    </div>
    <center>
    <div id="medicine" hidden>
        <center>套餐药品显示区</center>
        <div class="search">
            <span>
            <button id="searchs">添加药品</button>
                </span>
        </div>
        <table class="centre">
            <thead>
            <td>套餐</td>
            <td>药品</td>
            <td>数量</td>
            <td>删除</td>
            </thead>
            <%--<tr class="maintain">

            </tr>--%>
        </table>
    </div>
    </center>
    <table class="left">
        <thead> 
            <td>序号</td> 
            <td>病人</td>
            <td>显示病人信息</td>
            <%--<td>医生</td>
            <td>就诊时间</td> 
            <td>症状</td> 
            <td>医生建议</td> 
            <td>就诊次数</td> 
            <td>状态(1:已就诊2:已缴费3:已领药)</td> 
            <td>编辑</td> 
            <td>删除</td>--%>
        </thead> 
        <c:forEach items="${list}" var="doctorVisitRecord" varStatus="status"> 
            <tr>
<%--                <input class="patient" value="${doctorVisitRecord.patientId}" hidden>--%>
                <td>${status.index+1}</td> 
                <td>${doctorVisitRecord.basePatientInfo.patientName}</td>
                <td name="${doctorVisitRecord.patientId}"><a href="#" class="show1">病人信息</a></td>
                <%--<td>${doctorVisitRecord.doctorId}</td>
                <td>${doctorVisitRecord.visitDate}</td> 
                <td>${doctorVisitRecord.symptom}</td> 
                <td>${doctorVisitRecord.advice}</td> 
                <td>${doctorVisitRecord.times}</td> 
                <td>${doctorVisitRecord.status}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${doctorVisitRecord.vrId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${doctorVisitRecord.vrId}"></td> --%>
            </tr> 
        </c:forEach> 
    </table>
</body> 
</html> 
