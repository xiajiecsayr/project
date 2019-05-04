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
<form action="${path}/study/update.action"> 
    <h1>修改人物表</h1> 
    <input type="hidden" name="sId" value="${study.sId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>学生姓名</span> 
            <input type="text" name="sName" value="${study.sName}"> 
        </div> 
        <div class="right"> 
            <span>性别</span> 
            <input type="text" name="sSex" value="${study.sSex}"> 
        </div> 
        <div class="left"> 
            <span>年龄</span> 
            <input type="text" name="sAge" value="${study.sAge}"> 
        </div> 
        <div class="right"> 
            <span>地址id</span> 
            <input type="text" name="sSiteid" value="${study.sSiteid}"> 
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
 
