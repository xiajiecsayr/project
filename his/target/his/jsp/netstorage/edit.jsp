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
<form action="${path}/netstorage/update.action"> 
    <h1>修改文件表</h1> 
    <input type="hidden" name="fileid" value="${netstorage.fileid}"> 
    <div class="update"> 
        <div class="left"> 
            <span></span> 
            <input type="text" name="filename" value="${netstorage.filename}"> 
        </div> 
        <div class="right"> 
            <span></span> 
            <input type="text" name="filesize" value="${netstorage.filesize}"> 
        </div> 
        <div class="left"> 
            <span></span> 
            <input type="date" name="uploaddate" value="${netstorage.uploaddate}"> 
        </div> 
        <div class="right"> 
            <span></span> 
            <input type="text" name="uid" value="${netstorage.uid}"> 
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
 
