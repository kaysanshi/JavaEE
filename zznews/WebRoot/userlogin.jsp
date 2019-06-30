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
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="admin/css/public.css" />
<link rel="stylesheet" type="text/css" href="admin/css/page.css" />
<script type="text/javascript" src="admin/js/jquery.min.js"></script>
<script type="text/javascript" src="admin/js/public.js"></script>
</head>

<body>

	<script>
   function change(){
     document.getElementById("checkcodeimg").src="checkcodeServlet?random="+Math.random();
   }
</script>

	<!-- 登录页面头部 -->
	<div class="logHead">
		<span style="font-size: 60px; background-color: #FFE4B5; color: #FFF;">郑州头条新闻</span>
	</div>
	<!-- 登录页面头部结束 -->

	<!-- 登录body -->
	<div class="logDiv">
		<img class="logBanner" src="admin/img/logBanner.png" />
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
			</div>
			<!-- 输入框 -->
			<form action="userServlet?action=login" method="post">
				<div class="lgD">
					<img class="img1" src="admin/img/logName.png" /> <input
						type="text" id="username" name="username" placeholder="输入用户名" />
				</div>

				<div class="lgD">
					<img class="img1" src="admin/img/logPwd.png" /> <input
						type="password" id="password" name="password" placeholder="输入用户密码" />
				</div>

				<div class="lgD logD2">
					<input class="getYZM" type="text" name="checkcode" />
					<div class="logYZM">
						<img class="yzm" id="checkcodeimg" src="checkcodeServlet"
							onclick="change();" />
					</div>
				</div>
				<div class="logC">
					<button type="submit">登陆</button>
				</div>
			</form>
			<div class="logC">
				<button onclick="window.location.href='forget.jsp'">忘记密码</button>
			</div>
		</div>
	</div>
	<!-- 登录body  end -->
</body>
</html>