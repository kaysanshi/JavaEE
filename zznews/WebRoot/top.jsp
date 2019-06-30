<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
   function change(){
     document.getElementById("checkcodeimg").src="checkcodeServlet?random="+Math.random();
   }
</script>
<div style="background: #ccc; text-align: center" float="left">
	<c:if test="${user==null}">
		<a href="userlogin.jsp">登陆</a>
		<a href="register.jsp">注册</a>
	</c:if>
	<c:if test="${user!=null}">
	    上一次登录时间：${user.lastlogintime}<a href="userindex.jsp">会员中心</a> ，<a
			href="userServlet?action=logout">注销</a>
	</c:if>
</div>