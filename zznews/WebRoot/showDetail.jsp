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

<title>在线产品列表</title>

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
	<table align="center" width="700" border="1" cellspacing="0"
		cellpadding="0" bordercolor="#006699"
		style="border-collapse: collapse">
		<tr>
			<td><%@ include file="top.jsp"%></td>
		</tr>

		<tr>
			<td><%@ include file="nav.jsp"%></td>
		</tr>
		<tr>
			<td height="96">
				<!-- 产品的详细信息 start -->
				<table width="100%" border="0">
					<tr>
						<td width="19%" height="177"><img src="${record.picture}"
							width="150" height="150" /></td>
						<td width="81%">${record.title}<br /> 添加时间：${record.addtime}
							<br />

						</td>
					</tr>
					<tr>
						<td height="95" colspan="2">新闻详情：<br /> ${record.content}
						</td>
					</tr>
				</table> <!-- 产品的详细信息 end-->



			</td>
		</tr>
		<tr>
			<td><%@ include file="commentlist.jsp"%>
			</td>
		</tr>


	</table>

</body>
</html>
