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

<title>会员中心</title>

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
	${message}
	<table align="center" width="900" border="0" cellspacing="0"
		cellpadding="0" bordercolor="#006699"
		style="border-collapse: collapse">

		<tr>
			<td><%@ include file="top.jsp"%></td>
		</tr>

		<tr>
			<td><%@ include file="nav.jsp"%></td>
		</tr>

		<tr>
			<td>当前位置：<b>用户中心</b>
			</td>
		</tr>
		<tr>
			<td height="96">
				<table width="100%">
					<tr>
						<td width="200">
							<!-- 左侧--> <%@ include file="userleft.jsp"%>
						</td>
						<td>
							<!-- 主体 start-->
							<div id="maintable"></div> <!-- 主体 end-->
						</td>
					</tr>

				</table>

			</td>
		</tr>

	</table>

</body>
</html>
