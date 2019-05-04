<%-- 
  Created by IntelliJ IDEA. 
  2018/12/19 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
    <script>
        $(function () {
            $("#inp1").keyup(function () {
                var $inp1 = $("#inp1").val();
                $.get("${path}/doctorMenu/ajaxSList.action",{menuName:$inp1},function (data) {
                    if(data.flag==true){
                        $("#sname").html("名称已经存在，请重新输入").css("color","red");
                    }else {
                        $("#sname").html("");
                    }
                },"json")
            });
            $("form").submit(function () {
                //如果有错误提示，不能注册
                    if($(".notice").html()!=null && $(".notice").html()!=""){
                        alert("有错误信息，请改正！")
                        return false;
                    }
                })

        });
    </script>
</head> 

<body class="main"> 
<form action="${path}/doctorMenu/insert.action"> 
    <h1>添加套餐表</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>套餐名称</span> 
            <input type="text" name="menuName" value="" id="inp1">
            <span class="notice" id="sname"></span>
        </div>
        <div class="left"> 
            <span>套餐描述</span> 
            <input type="text" name="description" value=""> 
        </div> 
        <div class="right"> 
            <span>套餐类型</span> 
            <input type="text" name="type" value=""> 
        </div>
        <center><span style="color: red">注意：套餐类型  当type为1：套餐仅自己可用
              type为2：套餐全科室都可用
              type为3：套餐所有医生都可用 </span></center>
        <div id="error"></div> 
        <div class="buttons"> 
            <input type="submit" value="提交">
            <input type="button" onclick="history.back()" value="返回"> 
        </div> 
    </div> 
</form> 
</body> 
</html> 
 
