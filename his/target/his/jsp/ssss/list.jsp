<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2018/12/28
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <script>
        $(function () {
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
<body>

<div id="div1" style="border: 1px crimson solid;width: 200px;height: 200px;">
    
</div>


</body>
</html>
