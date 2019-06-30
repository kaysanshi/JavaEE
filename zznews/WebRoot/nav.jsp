<%@ page language="java" import="java.util.*,com.category.dao.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%

   //调用DAO
   CategoryDAO categoryDAO=new CategoryDAO();
   //查询所有的分类
   List<Map<String,Object>> categroies=categoryDAO.list();
   
   request.setAttribute("categroies",categroies);

 %>
<head>
<link rel="stylesheet" href="css/head.css" />
</head>
<div class="headNav">
	<div class="navCon w1300">
		<div class="navCon-menu fl">
			<ul>
				<li><a href="index.jsp">首页</a></li>
				<li><a href="newsServlet?action=displayNews">推荐</a></li>
				<c:forEach items="${categroies}" var="record">
					<li><a
						href="newsServlet?action=displayNews&categoryid=${record.categoryid}">${record.name}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
