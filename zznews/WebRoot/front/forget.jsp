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
					<div riot-tag="baseLogin" service="#" captcha="" hidesns="">
						<div class="baseLogin">
							<form action="../userServlet?action=toInputAnswer" method="POST">
								<div class="input-field">
									<input id="mobile" type="text" name="username"
										autocomplete="off" spellcheck="false" placeholder="用户名">
								</div>

								<input type="submit" class="action-btn" value="确定">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>