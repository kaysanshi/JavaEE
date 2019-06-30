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
<title>用户信息修改</title>
<link rel="stylesheet" type="text/css" href="admin/css/css.css" />
<script type="text/javascript" src="admin/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="page ">
			<!-- 用户信息修改页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>用户信息修改</span>
				</div>
				<form action="userServlet?action=update" method="post">
					<div class="baBody">

						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：
							<select name="sex" class="input3">
								<option value="男"
									<c:if test="${record.sex=='男'}">selected</c:if>>男</option>
								<option value="女"
									<c:if test="${record.sex=='女'}">selected</c:if>>女</option>
							</select>
						</div>

						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：<input
								type="text" class="input3" name="phone" value="${record.phone}" />
						</div>

						<div class="bbD">
							密码提示问题： <select name="question" class="input3">
								<option value="我的小学老师是谁？"
									<c:if test="${record.question=='我的小学老师是谁？'}">selected</c:if>>我的小学老师是谁？</option>
								<option value="我的毕业学校是哪儿？"
									<c:if test="${record.question=='我的毕业学校是哪儿？'}">selected</c:if>>我的毕业学校是哪儿？</option>
								<option value="我的Java老师是谁？"
									<c:if test="${record.question=='我的Java老师是谁？'}">selected</c:if>>我的Java老师是谁？</option>
							</select>
						</div>

						<div class="bbD">
							密码提示答案：<input type="text" name="answer" value="${record.answer}"
								class="input3" />
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