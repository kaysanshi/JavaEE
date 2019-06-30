<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻分类列表</title>
<link rel="stylesheet" type="text/css" href="admin/css/css.css" />
<script type="text/javascript" src="admin/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="admin/js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="admin/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">分类管理</a>&nbsp;-</span>&nbsp;分类列表
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">

				<!-- banner 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">分类ID</td>
							<td width="355px" class="tdColor">分类名称</td>
							<td width="260px" class="tdColor">分类排序</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
						<tr>
							<c:forEach items="${records}" var="record">
								<tr>
									<td>${record.categoryid}</td>
									<td>${record.name}</td>
									<td>${record.sort}</td>
									<td><a
										href="categoryServlet?action=edit&categoryid=${record.categoryid}"><img
											class="operation" src="admin/img/update.png"></a> <a
										href="categoryServlet?action=del&categoryid=${record.categoryid}"><img
											class="operation delban" src="admin/img/delete.png"></td>
								</tr>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="10" align="center" height="30"><%@ include
									file="categoryPage.jsp"%></td>
						</tr>
					</table>
				</div>
				<!-- banner 表格 显示 end-->
			</div>
			<!-- banner页面样式end -->
		</div>

	</div>
</body>

<script type="text/javascript">
// 广告弹出框
$(".delban").click(function(){
  $(".banDel").show();
});
$(".close").click(function(){
  $(".banDel").hide();
});
$(".no").click(function(){
  $(".banDel").hide();
});
// 广告弹出框 end
</script>
</html>