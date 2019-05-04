<%-- 
  Created by IntelliJ IDEA. 
  2018/12/06 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/medicinePurchaseInfo/insert.action"> 
    <h1>添加药品采购表</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>药品</span> 
            <input type="text" name="medicineCodeid" value=""> 
        </div> 
        <div class="right"> 
            <span>供应商</span> 
            <input type="text" name="manCode" value=""> 
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
 
