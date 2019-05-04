<%-- 
  Created by IntelliJ IDEA. 
  2018/12/26 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/study/insert.action"> 
    <h1>添加人物表</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>学生姓名</span> 
            <input type="text" name="sName" value=""> 
        </div> 
        <div class="right"> 
            <span>性别</span> 
            <input type="text" name="sSex" value=""> 
        </div> 
        <div class="left"> 
            <span>年龄</span> 
            <input type="text" name="sAge" value=""> 
        </div> 
        <div class="right"> 
            <span>地址id</span> 
            <input type="text" name="sSiteid" value=""> 
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
 
