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
    <script type="text/javascript">
<%
    String mid  = request.getParameter("mid");
%>
        $(function () {
            /*$(".current").click(function () {
                window.parent.mainFrame.location.href = "{path}/baseUser/list.action";
            })
            $(".module").click(function () {
                window.parent.mainFrame.location.href = "{path}/baseMoudule/list.action";
            })
            $(".baseFunction").click(function () {
                window.parent.mainFrame.location.href = "{path}/baseFunction/list.action";
            })*/
            $.get("${path}/baseFunction/ajaxList.action",{mid:<%=mid%>},function (data) {
                var $leftNav = $(".left_nav");
                $(data).each(function () {
                    var $li = $("<li name='"+this.url+"'>"+this.fname+"</li>");
                    $li.appendTo($leftNav);
                })
                $("li").click(function () {
                    $("li").removeClass("current");
                    $(this).addClass("current");
                    var url = $(this).attr("name");
                    window.parent.mainFrame.location.href="${path}/"+url+".action";
                });
            },"json");
        })
    </script>
</head>
<body class="left">
<div class="page">
    <div class="margin_div">
        <div class="page_main">
            <ul class="left_nav">
               <%-- <li class="current">用户管理</li>
                <li class="department">部门管理</li>
                <li class="post">岗位管理</li>
                <li class="module">模块管理</li>
                <li class="baseFunction">功能管理</li>--%>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
