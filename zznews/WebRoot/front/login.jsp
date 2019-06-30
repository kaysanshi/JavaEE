<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>今日新闻</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body style="min-width: 1220px; overflow-x: hidden;">
	<a href="#" style="display: none;"></a>
	<div class="y-wrap">
		<div class="content">

			<div riot-tag="loginBox" class="loginBox">
				<div class="login-type">
					<div riot-tag="baseLogin" service="https://www.toutiao.com/"
						captcha="" hidesns="">
						<div class="baseLogin">
							<form action="../userServlet?action=login" method="POST">
								<div class="input-field">
									<input id="mobile" type="text" name="username"
										autocomplete="off" spellcheck="false" placeholder="用户名">
								</div>
								<div class="input-field verification">
									<input id="captcha1" type="password" name="password"
										autocomplete="off" spellcheck="false" placeholder="密码">
									<div class="captcha-wrap">
										<img class="y-right captcha" alt=""
											src="./images/c1ef6cc5-9a12-423d-b155-b2af81bafb4b.gif">
										<span class="tips-bubble">看不清楚？换一张</span>
									</div>
								</div>
								<div class="input-field phone-code">
									<input id="code" type="text" name="checkcode"
										autocomplete="off" spellcheck="false" placeholder="验证码">
									<img height="50px" width="80px" id="checkcodeimg"
										src="../checkcodeServlet" onclick="change();" />
								</div>
								<div class="y-box action">
									<input id="agreement" class="agreement" type="checkbox" checked>
									<label for="agreement">我已阅读并同意<a href="#"
										target="_blank">用户协议</a>和<a href="#" target="_blank">隐私条款</a></label>
								</div>
								<input type="submit" class="action-btn" value="登录"> <input
									type="button" class="action-btn"
									onclick="window.location.href='forget.jsp'" value="忘记密码">
							</form>
							<ul class="sns-login">
								<li data-pid="mail_phone" class="sns  mail-login"><span>账号</span>
								</li>
								<li class="sns qq-login" data-pid="qzone_sns"><span>QQ</span>
								</li>
								<li class="sns weixin-login" data-pid="weixin"><span>微信</span>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
   function change(){
     document.getElementById("checkcodeimg").src="checkcodeServlet?random="+Math.random();
   }
</script>
</html>