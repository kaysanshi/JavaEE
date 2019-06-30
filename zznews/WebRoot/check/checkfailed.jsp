<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>审核通过</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	
		//跳转取消界面
		function esc()

        {

        window.location.herf("/zznews/newsServlet?action=querynews&statuscode=888");

        }
		
</script>

<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

</head>

<body>
	${message}
	<form id="form" action="/zznews/newsServlet?action=checkfailed"
		method="post">
		<table cellspacing="0" cellpadding="0" width=“100”>
			<tr>
				<td><label>新闻ID：</label> <input type="text" readonly="readonly"
					id="newsid" name="newsid" style="width: 50%;"
					value="${record.newsid}" /></td>
			</tr>

			<tr>
				<td><label>审核人ID：</label> <input readonly="readonly"
					type="text" id="adminid" name="adminid" style="width: 50%;"
					value="${records.adminid}" /></td>
			</tr>

			<tr>
				<td><label>新闻状态：</label> <input readonly="readonly" type="text"
					name="status" style="width: 50%;" value="${record.status}" /></td>
			</tr>
			<tr>
				<td><label>审核未通过原因：</label></td>
			</tr>
			<tr>
				<td><textarea id="reason" name="reason" rows="10" cols="70"></textarea>

				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="newsid"
					value="${record.newsid}" /> <input type="hidden" name="adminid"
					value="${records.adminid}" /> <input type="button"
					style="width: 80px; height: 30px; background-color: #32CD32; color: #FFF;"
					value="确定" onclick="form.submit();"> <input type="button"
					style="width: 80px; height: 30px; background-color: #e0e0e0; color: #FFF;"
					value="取消" onclick="esc()" /></td>
			</tr>

		</table>
	</form>
</body>
</html>
