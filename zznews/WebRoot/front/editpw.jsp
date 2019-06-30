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
							<form action="../userServlet?action=updatepwd" method="POST">
								<div class="input-field">
									<input id="mobile" type="text" name="oldpwd" autocomplete="off"
										spellcheck="false" placeholder="原密码">
								</div>
								<div class="input-field verification">
									<input id="captcha1" type="text" name="password1"
										autocomplete="off" spellcheck="false" placeholder="新密码">

								</div>
								<div class="input-field verification">
									<input id="captcha1" type="text" name="password2"
										autocomplete="off" spellcheck="false" placeholder="新密码">

								</div>
								<div class="input-field phone-code">
									<input id="code" type="text" name="checkcode"
										autocomplete="off" spellcheck="false" placeholder="验证码">
									<img height="50px" width="80px" id="checkcodeimg"
										src="../checkcodeServlet" onclick="change();" />
								</div>
								<input type="submit" class="action-btn" value="确认"
									onclick="form.submit();">
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