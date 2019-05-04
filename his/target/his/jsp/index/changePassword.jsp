<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/3 0003
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        span{
            display: inline-block;
            width: 30%;
        }
        input[type='text'],input[type='datetime']{
            margin-top: 10px;
        }
    </style>
    <script>
        $(function () {
            $("#oldPassword").blur(function () {
                var oldPassword = $("#oldPassword").val();
                $.get("${path}/baseUser/old.action",{password:oldPassword,userId:${sessionUser.userId}},function (data) {
                        if(data=="Y"){
                            $("#passwordold").html("");
                        }
                        if(data=="N"){
                            $("#passwordold").html("旧密码输入错误！").css("color","red");

                        }
                })
            });
            $("#repeatPassword").blur(function () {
                var password = $("#password").val();
                var repeatPassword = $("#repeatPassword").val();
                if(password!=repeatPassword){
                    $("#passwordsold").html("两次密码不一样！").css("color","red");
                }else {
                    $("#passwordsold").html("");
                }

            });
            $("#submit").click(function () {
                var flag=true;
                var password = $("#password").val();
                $("input[type='text']").each(function () {
                    if(!$(this).val()){
                        alert("请将信息补充完整！")
                        flag=false;
                    }
                });
                $(".tion").each(function () {
                    if($(this).html()){
                        alert("有错误信息！")
                        flag=false;
                    }
                });
                if(flag){
                    alert("验证通过！")
                    $.get("${path}/baseUser/updetpassword.action",{password:password,userId:"${sessionUser.userId}"},function (data) {
                        if(data=="Y"){
                            alert("更改成功！");
                            window.close();
                            window.opener.top.location="${path}/baseUser/logout.action";

                        }
                        if(data=="N"){
                            alert("更改失败！");
                        }

                    })
                }

            });
        })
    </script>
</head>

<body class="main">
    <h1>修改密码</h1>
        <div class="update">
            <div class="left">
                <span>请输入旧密码</span>
                <input type="text" id="oldPassword"><span class="tion" id="passwordold"></span>
            </div>
            <div class="right">
            </div>
            <div class="left">
                <span>新密码</span>
                <input type="password" name="password" id="password">
            </div>
            <div class="right">
            </div>
            <div class="left">
                <span>确认密码</span>
                <input type="password" id="repeatPassword"><span class="tion" id="passwordsold"></span>
            </div>
            <div class="buttons">
                <input type="submit" value="提交" id="submit">
                <input type="button" onclick="history.back()" value="返回">
            </div>
        </div>
</body>

</html>
