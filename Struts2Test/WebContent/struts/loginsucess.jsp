<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login登录成功后</title>
</head>
<body>
<ul>
	<li>用户名：<s:property value="name"/></li>
	<li>密码：<s:property value="password"/></li>
	<li>性别：<s:if test="sex==0">女</s:if><s:if test="sex==1">男</s:if></li>
	<li>省份：<s:property value="province"/></li>
	<li>爱好：<s:property value="hobby"/></li>
	<li>描述：<s:property value="descrption"/></li>
</ul>
</body>
</html>