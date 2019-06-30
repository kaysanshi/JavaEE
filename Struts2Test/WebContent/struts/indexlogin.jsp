<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>
</head>
<body>
		<s:form action="userAction!register" method="post">
			<s:textfield name="name" label="用户名" required="true" requiredposition="left"></s:textfield>
			<s:password name="password" label="密码" required="true" requiredposition="left"></s:password>
			<s:radio name="sex" list="#{1:'男',0:'女'}" label="性别" required="true" requiredposition="left"></s:radio>
			<s:select list="{'请选择省份','河南','河北','上海','北京'}" name="province" label="省份"></s:select>
			<s:checkboxlist list="{'足球','篮球','乒乓','排球'}" name="hobby" label="爱好"></s:checkboxlist>
			<s:submit value="注册"></s:submit>
			<s:reset value="重置"></s:reset>
		</s:form>
</body>
</html>