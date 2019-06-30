<%@ page language="java" import="java.util.*,com.comment.dao.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<b>商品评论</b>
<br />
<c:if test="${user!=null}">
	<form action="newsServlet?action=addcomment" method="post">

		标题：<input type="text" name="title"><br /> 内容：
		<textarea name="content" rows="6" cols="30"></textarea>
		<br /> <input type="hidden" name="newsid" value="${record.newsid}">
		<input type="button" value="评论" onclick="form.submit();">
	</form>
</c:if>
<br />
<br />

<%
   CommentDAO commentDAO=new CommentDAO();
   
   Map<String,Object> record=(Map<String,Object>)request.getAttribute("record");
   int newsid=Integer.parseInt(record.get("newsid").toString());
   //评论列表
   List<Map<String,Object>> comments=commentDAO.getCommentsByProductid(newsid);
   request.setAttribute("comments",comments);

%>
<c:forEach items="${comments}" var="record">
    标题：${record.title}   <br>
    
评论时间：${record.addtime} 评论客户：${record.username} <br>
   
    内容：${record.content}
</c:forEach>
