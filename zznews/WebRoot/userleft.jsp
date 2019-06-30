<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<script>
	
	    /* 
		 * 打开新窗口 
		 * f:链接地址 
		 * n:窗口的名称 
		 * w:窗口的宽度 
		 * h:窗口的高度 
		 * s:窗口是否有滚动条，1：有滚动条；0：没有滚动条 
		 */  
		function openWindow(f,n,w,h,s){  
		   sb = s == "1" ? "1" : "0";  
		    l = (screen.width - w)/2;  
		   t = (screen.height - h)/2;  
		   sFeatures = "left="+ l +",top="+ t +",height="+ h +",width="+ w  
		            + ",center=1,scrollbars=" + sb + ",status=0,directories=0,channelmode=0";  
		   openwin = window.open(f , n , sFeatures );  
		   if (!openwin.opener)  
		        openwin.opener = self;  
		    openwin.focus();  
		    return openwin;  
		}
		
	</script>


<div>

	<b>用户操作</b><br /> 我的订单<br /> ---<a
		href="newsServlet?action=myorder&statuscode=1">我的新闻</a><br /> ---<a
		href="newsServlet?action=myorder&statuscode=2">审核成功的新闻</a><br /> ---<a
		href="newsServlet?action=myorder&statuscode=3">审核未成功的新闻</a><br /> 个人信息<br />
	---<a href="userServlet?action=edit">修改信息</a><br /> ---<a
		href="editpwd.jsp">修改密码</a><br /> <a
		href="newsServlet?action=mycomment">我的评论</a><br />


</div>