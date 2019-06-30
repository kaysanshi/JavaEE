<%@ page language="java" import="java.util.*,com.category.dao.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
  CategoryDAO dao1=new CategoryDAO();
  List<Map<String,Object>> temps=dao1.list();
  request.setAttribute("temps",temps);

%>
<form action="newsServlet?action=search" method="post">
	<table width="100%">
		<tr>
			<td>当前位置：首页>>${categoryname}</td>
			<td style="text-align: right">关键字：<input type="text"
				name="keyword" value="${keyword}"> <select name="categoryid">
					<option value="0">全部新闻</option>
					<c:forEach items="${temps}" var="record">
						<option value="${record.categoryid}"
							<c:if test="${categoryid==record.categoryid}">selected</c:if>>${record.name}</option>
					</c:forEach>
			</select> <input type="button" value="新闻搜索" onclick="form.submit();">

			</td>
		</tr>
	</table>
</form>