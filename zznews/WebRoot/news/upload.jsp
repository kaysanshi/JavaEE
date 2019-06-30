<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>文件上传</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>
   
       //简化获取ID
	     function $(id){
		    return document.getElementById(id);
		 }
   
      //将上传后的文件路径从子页面传回到父页面
      function setUploadFile(){
            var filepath=$("filepath");
            var photo=window.opener.document.getElementById("picture");
            photo.value=filepath.value;
            //关闭窗口
            window.close();
      }
   
   </script>



</head>

<body>
	${message}
	<form action="/zznews/newsServlet?action=upload" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file"> <input type="submit"
			name="submit" value="上传" /><br /> <input type="hidden" id="filepath"
			name="filepath" value="${filepath}"> <input type="button"
			value="确定" onclick="setUploadFile();">
	</form>
</body>
</html>
