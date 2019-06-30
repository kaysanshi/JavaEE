<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


共找到${totalCount}条记录，当前第${currentPage}页，
<a href="newsServlet?action=list&currentPage=1">首页</a>
<c:if test="${currentPage==1}">上一页</c:if>
<c:if test="${currentPage!=1}">
	<a href="newsServlet?action=list&currentPage=${currentPage-1}">上一页</a>
</c:if>
<c:if test="${currentPage==totalPage}">下一页</c:if>
<c:if test="${currentPage!=totalPage}">
	<a href="newsServlet?action=list&currentPage=${currentPage+1}">下一页</a>
</c:if>
<a href="newsServlet?action=list&currentPage=${totalPage}">尾页</a>