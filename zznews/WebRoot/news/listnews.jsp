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
<title>新闻列表显示</title>
<link rel="stylesheet" type="text/css" href="admin/css/css.css" />
<script type="text/javascript" src="admin/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="admin/js/page.js" ></script> -->
<script>
	
	    /* 
		 * 打开新窗口 
		 * f:链接地址 
		 * n:窗口的名称 
		 * w:窗口的宽度 
		 * h:窗口的高度 
		 * s:窗口是否有滚动条，1：有滚动条；0：没有滚动条 
		 */  
		function openWindow(f,n,w,h,s){  
		   sb = s == "1" ? "1" : "0";  
		    l = (screen.width - w)/2;  
		   t = (screen.height - h)/2;  
		   sFeatures = "left="+ l +",top="+ t +",height="+ h +",width="+ w  
		            + ",center=1,scrollbars=" + sb + ",status=0,directories=0,channelmode=0";  
		   openwin = window.open(f , n , sFeatures );  
		   if (!openwin.opener)  
		        openwin.opener = self;  
		    openwin.focus();  
		    return openwin;  
		}
	</script>
</head>

<body>
	${message}
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="admin/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">新闻管理</a>&nbsp;-</span>&nbsp;新闻列表
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<form>
						<div class="cfD">
							<input class="addUser" type="text" name="keyword"
								value="${keyword}" placeholder="输入用户名或标题" />
							<button class="button"
								onclick="location.href='newsServlet?action=afternewssearch&keyword=${record.keyword}'">搜索</button>
						</div>
					</form>
				</div>
				<!-- banner 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC">新闻ID</td>
							<td width="355px" class="tdColor">新闻标题</td>
							<td width="260px" class="tdColor">添加时间</td>
							<td width="275px" class="tdColor">新闻封面</td>
							<td width="290px" class="tdColor">新闻类别</td>
							<td width="290px" class="tdColor">新闻作者</td>
							<td width="290px" class="tdColor">新闻状态</td>
							<td width="200px" class="tdColor">操作</td>
						</tr>
						<tr>
							<c:forEach items="${records}" var="record">
								<tr>
									<td>${record.newsid}</td>
									<td>${record.title}</td>
									<td>${record.addtime}</td>
									<td><img src="${record.picture}" width="100" height="100" /></td>
									<td>${record.categoryname}</td>
									<td>${record.userid}</td>
									<td>${record.status}</td>
									<td>
										<button type="button"
											onclick="openWindow('newsServlet?action=newsDetail&newsid=${record.newsid}',1000,500,1);">
											<img class="operation" src="admin/img/coin11.png">
										</button> <a href="newsServlet?action=edit&newsid=${record.newsid}"><img
											class="operation" src="admin/img/update.png"></a> <a
										href="newsServlet?action=del&newsid=${record.newsid}"><img
											class="operation delban" src="admin/img/delete.png">
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="10" align="center" height="30"><%@ include
										file="page.jsp"%></td>
							</tr>
					</table>
				</div>
				<!-- banner 表格 显示 end-->
			</div>
			<!-- banner页面样式end -->
		</div>

	</div>

</body>


</html>