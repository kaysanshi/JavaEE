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
<title>输入答案</title>
<link rel="stylesheet" type="text/css" href="admin/css/css.css" />
<script type="text/javascript" src="admin/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="page ">
			<!-- 找回密码页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>找回密码</span>
				</div>
				<form action="userServlet?action=answer" method="post">
					<div class="baBody">
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<input
								type="text" class="input3" name="username"
								value="${record.username}" readonly="readonly" />
						</div>

						<div class="bbD">
							密码提示问题：<input type="text" name="question"
								value="${record.question}" readonly="readonly" class="input3" />
						</div>

						<div class="bbD">
							密码提示答案：<input type="text" class="input3" name="answer" value="" />
						</div>

						<div class="bbD">
							<p class="bbDP">
								<button class="btn_ok btn_yes" onclick="form.submit();">提交</button>
								<a class="btn_ok btn_no" href="#">取消</a>
							</p>
						</div>
					</div>
				</form>
			</div>
			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
</html>