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
<title>注册用户</title>
<link rel="stylesheet" type="text/css" href="admin/css/css.css" />
<script type="text/javascript" src="admin/js/jquery.min.js"></script>
<script type="text/javascript">
    <!--
	var xmlHttp = null;
	function init(){
		   if(window.XMLHttpRequest){
			    //非IE浏览器，用xmlhttprequest对象创建
			    xmlHttp = new XMLHttpRequest();
		   } else {
			    //IE浏览器用activexobject对象创建
			    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		   }
    }
    
    //用于响应用户的点击
	function check(){
	
	   //创建一个XMLHTTP
	   if(xmlHttp == null){
	      init();
	   }
	   var time = new Date().getTime();
	   var username = document.getElementById("username").value;

	   //要请求的服务端地址
	   var url = "userServlet?action=validateUsername&time="+time;
	   //与服务端建立连接(请求方式post或get，地址,true表示异步)
	   xmlHttp.open("POST", url, true);
	   //指定回调函数
	   xmlHttp.onreadystatechange = checkCallback;
	   //定义传输的文件HTTP头信息 
       xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
	   //发送请求
	   xmlHttp.send("username="+username);
	}

	//回调函数，对服务端的响应处理，监视response状态
	function checkCallback(){
	   //请求状态为4表示成功
	   if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
	        //接收返回的结果
		    var b = xmlHttp.responseText;
		    //alert(b);
		    if(b == "1"){
		        document.getElementById("checkmessage").innerHTML = "<b style='color:green'>恭喜你，用户名可以使用！</b>";
		    } else {
		        document.getElementById("checkmessage").innerHTML = "<b style='color:red'>抱歉，用户名已经占用！</b>";
		    }
	   }
	}
   //-->
</script>

</head>
<body>
	${message}
	<div id="pageAll">
		<div class="page ">
			<!-- 用户注册页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>用户注册</span>
				</div>
				<form action="userServlet?action=register" method="post">
					<div class="baBody">
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<input
								type="text" id="username" name="username" class="input3" /> <input
								type="button" value="检测用户名" onclick="check();"> <span
								id="checkmessage"></span>
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：<input
								type="password" name="password1" class="input3" />
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认密码：<input
								type="password" name="password2" class="input3" />
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：
							<select name="sex" class="input3">
								<option value="男"
									<c:if test="${record.sex=='男'}">selected</c:if>>男</option>
								<option value="女"
									<c:if test="${record.sex=='女'}">selected</c:if>>女</option>
							</select>
						</div>
						<div class="bbD">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：<input
								type="text" name="phone" value="${record.phone}" class="input3" />
						</div>
						<div class="bbD" class="input3">
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