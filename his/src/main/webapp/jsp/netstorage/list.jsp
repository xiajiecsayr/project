<%-- 
  Created by IntelliJ IDEA. 
  2018/12/20 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () {
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/netstorage/add.jsp";
             })
            $(".update").click(function () { 
                var fileid = $(this).attr("name");
                location.href="${path}/netstorage/load.action?fileid="+fileid;
             })
            $(".delete").click(function () { 
                var fileid = $(this).attr("name");
                location.href="${path}/netstorage/delete.action?fileid="+fileid;
             })
            $("#search").click(function () { 
                var filename = $("#filename").val();
                location.href = "${path}/netstorage/search.action?filename="+filename;
             })
            $("#sel").change(function () {
                var $sel = $(this).val();
                var $left = $(".left");
                $left.empty();
                for (var i =1;i<=$sel;i++){
                    var $span = $("<span>选择文件:</span>");
                    var $open = $('<input type="text" placeholder="请点击选择文件" name="photo" id="photo'+i+'"><br/>');
                    $span.appendTo($left);
                    $open.appendTo($left);
                }
            });
            //上传文件
            $(".left").delegate("input","click",function () {
                window.open('${path}/file/upload.jsp?nameProp='+$(this).attr("id")+'', '文件上传', 'height=150, width=300, top=200, left=500');
            });
            //上传
            $("#tianjia").click(function () {
                var wenjian = "";
                $(".left input").each(function () {
                    wenjian+=$(this).val()+",";
                })
                location.href="${path}/netstorage/addscommodity.action?wenjian="+wenjian;
            });
        })  
    </script> 
</head> 
<body class="main">
    <div class="search">
        <center>网络U盘</center>
        <span> 
         文件名   ：<input type="text" id="filename" value="${searchObject.filename}">
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span> 
    </div> 
    <table> 
        <thead> 
            <td>序号</td> 
            <td>文件名</td>
            <td>文件大小</td>
            <td>上传日期</td>
            <td>上传用户</td>
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="netstorage" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${netstorage.filename}</td> 
                <td>${netstorage.filesize}字节</td>
                <td>${netstorage.uploaddate}</td> 
                <td>${netstorage.baseUser.cname}</td>
                <td><img src="${path}/images/del.gif" class="delete" name="${netstorage.fileid}"></td> 
            </tr> 
        </c:forEach> 
    </table>
<h3>上传文件模块</h3>
     上传数量:<select id="sel">
        <option>1</option>
        <option>2</option>
        <option>3</option>
    </select>
    <div class="left">
    <span>选择文件</span>
      <input type="text" placeholder="请点击选择文件" name="photo" id="photo"><br/>
    </div>
    <button id="tianjia">上传</button>
</body> 
</html> 
