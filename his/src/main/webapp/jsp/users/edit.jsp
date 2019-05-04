<%-- 
  Created by IntelliJ IDEA. 
  2018/12/20 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/users/update.action"> 
    <h1>修改用户表</h1> 
    <input type="hidden" name="uid" value="${users.uid}"> 
    <div class="update"> 
        <div class="left"> 
            <span></span> 
            <input type="text" name="uname" value="${users.uname}"> 
        </div> 
        <div class="right"> 
            <span></span> 
            <input type="text" name="pwd" value="${users.pwd}"> 
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
 
