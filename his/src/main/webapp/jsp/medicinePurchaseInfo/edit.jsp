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
<form action="${path}/medicinePurchaseInfo/updateSelective.action">
    <h1>修改药品采购表</h1> 
    <input type="hidden" name="pchId" value="${medicinePurchaseInfo.pchId}"> 
    <div class="update">
        <div class="left"> 
            <span>采购数量</span> 
            <input type="text" name="pchAmt" value="${medicinePurchaseInfo.pchAmt}"> 
        </div> 
        <div class="right"> 
            <span>采购单价</span> 
            <input type="text" name="pchPrice" value="${medicinePurchaseInfo.pchPrice}"> 
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
 
