<%@ page language="java" import="java.util.*,com.comment.dao.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/index.css">
<title>Insert title here</title>
</head>
<body>
	<div class="bui-box container">
		<div ga_event="channel_click" class="bui-left index-channel">
			<div>
				<div ga_event="left-channel-click" class="channel">
					<a href="#" class="logo"><img src="images/logo.201f80d.png"
						style="width: 108px; height: 27px;"></a>
					<!---->

					<ul>
						<li><a href="#" target="_self"
							ga_event="channel_recommand_click" class="channel-item active"><span>我的</span></a>
						</li>

						<li><a href="#" class="channel-item"><span>我的信息</span></a></li>
						<li><a href="#" class="channel-item"><span>我的评论</span></a></li>
						<li><a href="javascript:void(0)" class="channel-item"
							onclick="show()"><span>修改密码</span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<script>
				function show(){
					
					document.getElementById("center").innerHtml="<object type="text/html" data='/zznews/front/editpw.jsp' width="100%"></object>";
				}
			</script>
		<div class="bui-left index-content" id="center"></div>
	</div>
	<div id="buttom"></div>
</body>
</html>