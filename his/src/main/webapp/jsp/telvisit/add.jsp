<%-- 
  Created by IntelliJ IDEA. 
  2018/12/05 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
    <%
        String cid = request.getParameter("cid");
    %>
    <script>
        $(function () {
            $.get("${path}/telvisit/ajaxList.action",function (data) {
                var $se = $("#se");
                $(data).each(function () {
                    var $option = $("<option value='"+this.visitreason+"'>"+this.visitreason+"</option>");
                    $option.appendTo($se);
                });
            },"json");
            $.get("${path}/telvisit/ajaxList.action",function (data) {
                var $sel = $("#sel");
                $(data).each(function () {
                    var $option = $("<option value='"+this.visittype+"'>"+this.visittype+"</option>");
                    $option.appendTo($sel);
                });
            },"json")
        })
    </script>
</head> 

<body class="main"> 
<form action="${path}/telvisit/insert.action"> 
    <h1>添加回访信息表</h1> 
    <div class="update">
        <div class="left"> 
            <span>回访人姓名</span> 
            <input type="text" name="telname" value=""> 
        </div> 
        <div class="right"> 
            <span>回访时间</span> 
            <input type="date" name="teltime" value=""> 
        </div> 
        <div class="left"> 
            <span>回访分类</span>
            <select id="se" name="visitreason">
            </select>
        </div> 
        <div class="right"> 
            <span>回访结果</span> 
            <input type="text" name="visitreturn" value=""> 
        </div> 
        <div class="left"> 
            <span>回访方式</span>
            <select id="sel" name="visittype">
            </select>
        </div> 
        <div class="right"> 
            <span>所属公司编号</span> 
            <input type="text" name="cid" value="<%=cid%>">
        </div> 
        <div id="error"></div> 
        <div class="buttons"> 
            <input type="submit" value="提交"> 
            <input type="button" onclick="history.back()" value="返回"> 
        </div> 
    </div> 
</form> 
</body> 
</html> 
 
