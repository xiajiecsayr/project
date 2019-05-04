<%-- 
  Created by IntelliJ IDEA. 
  2018/12/25 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/test1/insert.action"> 
    <h1>添加测试地址表</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>地址名</span> 
            <input type="text" name="aName" value=""> 
        </div> 
        <div class="right"> 
            <span>用户id</span> 
            <input type="text" name="tId" value=""> 
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
 
