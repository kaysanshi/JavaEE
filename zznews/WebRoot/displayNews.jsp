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

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" href="css/head.css" />


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
	<table align="center" width="100%" border="0" cellspacing="0"
		cellpadding="0" bordercolor="#006699"
		style="border-collapse: collapse">

		<tr>
			<td><%@ include file="top.jsp"%></td>
		</tr>

		<tr>
			<td><%@ include file="nav.jsp"%></td>
		</tr>
	</table>


	<table align="center" width="100%" border="0" cellspacing="0"
		cellpadding="0" bordercolor="#006699"
		style="border-collapse: collapse">
		<tr>
			<td><%@ include file="position.jsp"%></td>
		</tr>
		<tr>
			<td height="96">
				<!-- 排序 start -->
				<div>
					排序：<a
						href="newsServlet?action=displayNews&orderfield=myprice&ordervalue=asc&categoryid=${categoryid}">价格升序</a>
					<a
						href="productServlet?action=displayProducts&orderfield=myprice&ordervalue=desc&categoryid=${categoryid}">价格降序</a>
					<a
						href="productServlet?action=displayProducts&orderfield=hit&ordervalue=asc&categoryid=${categoryid}">人气升序</a>
					<a
						href="productServlet?action=displayProducts&orderfield=hit&ordervalue=desc&categoryid=${categoryid}">人气降序</a>
					<a
						href="productServlet?action=displayProducts&orderfield=time&ordervalue=asc&categoryid=${categoryid}">上架时间升序</a>
					<a
						href="productServlet?action=displayProducts&orderfield=time&ordervalue=desc&categoryid=${categoryid}">上架时间降序</a>
				</div> <!-- 排序 end --> <!--产品列表 start-->
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					style="font-size: 13px;">
					<c:forEach items="${records}" var="record" varStatus="status">
						<c:if test="${status.index%4==0}">
							<tr>
						</c:if>
						<td width="25%" style="line-height: 25px; text-align: center">
							<a href="newsServlet?action=showDetail&newsid=${record.newsid}"><img
								src="${record.picture}" width="200" height="200" border="0" /></a><br />
							<a href="newsServlet?action=showDetail&newsid=${record.newsid}">${record.title}</a><br />
							<span style="color: red"></span> <s>${record.adddtime} </s>
						</td>
						<c:if test="${status.index%4==3}">
							<tr></tr>
						</c:if>
					</c:forEach>
					<c:if test="${totalCount%4!=0 && currentPage==totalPage}">
						<tr></tr>
					</c:if>
				</table> <!--产品列表 end-->
				<div align="center"><%@ include file="page2.jsp"%></div>


			</td>
		</tr>
	</table>

</body>
</html>


