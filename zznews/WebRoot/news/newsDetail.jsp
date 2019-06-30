<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新闻详情</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table align="center" width="900" border="1" cellspacing="0"
		cellpadding="0" bordercolor="#006699"
		style="border-collapse: collapse">



		<tr>
			<td height="96">
				<div>
					<b>新闻信息</b><br> 新闻编号：${record.newsid}<br>
					新闻状态：${record.status}<br> 新闻标题：${record.title}<br>
					新闻作者：${record.userid}<br> 新闻内容： ${record.content}<br>
				</div>


			</td>
		</tr>

	</table>

</body>
</html>
