
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29 0029
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>

<html>
<head>
    <%
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd E");
        String str = format.format(date);
            %>
    <script type="text/javascript">
        $(function () {
            <%--location.href="${path}/baseMoudule/lisst.action";--%>
            $.get("${path}/baseMoudule/lisst.action",function (data) {
                var tdiv = $(".nav");
                for(var i=0;i<data.length;i++){
                    $(data[i]).each(function () {
                        var ta = $("<a href='#' id='"+this.mid+"' target='_self'></a>");
                        var span = $("<span class=STYLE2>"+this.mname+"</span>");
                        span.appendTo(ta);
                        ta.appendTo(tdiv);
                    });
                }
                $(".nav a").click(function () {
                    window.parent.leftFrame.location.href="${path}/jsp/index/left.jsp?mid="+$(this).attr("id");
                });
            },"json");

            $("#logout").click(function () {
                window.parent.location.href="${path}/baseUser/logout.action";
            });
            $("#changePassword").click(function () {
                window.open('${path}/jsp/index/changePassword.jsp', 'oldPassword', 'height=600, width=800, top=100, left=200');
            });
        })
    </script>
</head>

<body>
<div class="page">
        <div class="nav">
                <%--<a href="#"  target="_self"><SPAN class=STYLE2>收费管理</SPAN></a>--%>
                <%--<a href="#"  target="_self"><SPAN class=STYLE2>药房管理</SPAN></a>--%>
                <%--<a href="#"  target="_self"><SPAN class=STYLE2>医生工作站</SPAN></a>--%>
                <%--<a href="#"  target="_self"><SPAN class=STYLE2>基础信息</SPAN></a>--%>
                <%--<a href="#"  target="_self"><SPAN class=STYLE2>统计分析</SPAN></a>--%>
        </div>
</div>
<div class="userInfo">
    <span>${sessionUser.cname}</span>
    <span><%=str%></span>
    <span> <a href="" id="logout">退出</a></span>
    <span><a href="" id="changePassword">修改密码</a></span>
</div>

</body>

</html>
