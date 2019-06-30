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
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="admin/css/css.css" />
<script type="text/javascript" src="admin/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<form action="userServlet?action=updatepwd" method="post">
					<div class="bbD">
						&nbsp;输入原始密码：<input type="password" class="input3" name="oldpwd"
							value="" /> <img class="imga" src="admin/img/ok.png" /><img
							class="imgb" src="admin/img/no.png" />
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;输入新密码：<input type="password"
							class="input3" name="password1" value="" /> <img class="imga"
							src="admin/img/ok.png" /><img class="imgb"
							src="admin/img/no.png" />
					</div>
					<div class="bbD">
						&nbsp;再次确认密码：<input type="password" class="input3"
							name="password2" value="" /> <img class="imga"
							src="admin/img/ok.png" /><img class="imgb"
							src="admin/img/no.png" />
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" onclick="form.submit();">确认</button>
							<a class="btn_ok btn_no" href="editpwd.jsp">取消</a>
						</p>
					</div>
				</form>
			</div>

			<!-- 修改密码页面样式end -->
		</div>
	</div>
</body>
</html>