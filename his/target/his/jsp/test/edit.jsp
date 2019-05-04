<%-- 
  Created by IntelliJ IDEA. 
  2018/12/24 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/test/update.action"> 
    <h1>修改测试表</h1> 
    <input type="hidden" name="tId" value="${test.TId}">
    <div class="update"> 
        <div class="left"> 
            <span>用户名</span> 
            <input type="text" name="tName" value="${test.TName}">
        </div> 
        <div class="right"> 
            <span>性别</span> 
            <input type="text" name="tSex" value="${test.TSex}">
        </div> 
        <div class="left"> 
            <span>年龄</span> 
            <input type="text" name="tAge" value="${test.TAge}">
        </div> 
        <div class="right"> 
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
 
