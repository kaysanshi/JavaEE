<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>管理员登录</title>
<link rel="stylesheet" type="text/css"
	href="css/front/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/front/login.css" />
</head>
<body>
	<div class="container-fluid">

		<div class="row " id="login">
			<!--左边-->
			<div class="col-sm-2 col-md-2 col-lg-2 col-xs-1"></div>
			<!--中间-->
			<div class="col-sm-8 col-md-8 col-lg-8 col-xs-10">
				<div class="container-fluid" id="main">

					<div class="row shuru">

						<div class="col-lg-2 col-sm-1 col-md-1 col-xs-1"></div>
						<!--内左-->

						<div class="col-lg-8 col-sm-10 col-md-10 col-xs-10 all">

							<div class="row logo">
								<!--logo标志上-->
								<span id="title">郑州头条新闻管理系统</span>
							</div>

							<div class="row login inputpanel" id="inputpanel">
								<!--中-->
								<div class="col-lg-2 col-md-2 col-sm-1 col-xs-1"></div>

								<div class="col-lg-8 col-md-8 col-sm-10 col-xs-10">

									<div class="row loginway">
										<span>管理员登录</span>
									</div>

									<!--输入框-->
									<form action="/zznews/adminServlet?action=login" method="post">
										<div class="row">
											<div id="messageError" class="messageError"
												style="z-index: 999; width: 100%; border: 1px solid black; border-radius: 10px; height: 30px; background-color: #CCCCCC; color: red; display: none;"></div>

											<div class="input-group inbor">
												<span class="input-group-addon imgchang" id="basic-addon1"><img
													src="img/front/login/input.png" /></span>

												<div class="parentCls">
													<input type="text" class="inputElem" id="adminname"
														name="adminname" placeholder="请输入账号" maxlength="11">
												</div>

											</div>

											<div class="input-group inbor">
												<span class="input-group-addon imgchang" id="basic-addon1"><img
													src="img/front/login/pwd.png" /></span> <input type="password"
													class="form-control intchang" id="password" name="password"
													placeholder="请输入密码" maxlength="6"
													aria-describedby="basic-addon1">
											</div>

										</div>
										<div class="row">

											<div class="col-md-3 logbtn">
												<button type="submit" class="btn btn-warning btn-block">登陆</button>
											</div>

										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="col-lg-2 col-sm-1 col-md-1 col-xs-1"></div>
						<!--内右边-->
					</div>
				</div>
			</div>
			<!--右边-->
			<div class="col-sm-2 col-md-2 col-lg-2 col-xs-1"></div>
		</div>
	</div>

</body>
</html>
