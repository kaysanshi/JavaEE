<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司信息设置</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$("body").css({visibility:"visible"});
		
		// 对save按钮条件 点击事件
		$('#save').click(function(){
			// 对form 进行校验
			if($('#noticebillForm').form('validate')){
				$('#noticebillForm').submit();
			}
		});
	});
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="north" style="height:31px;overflow:hidden;" split="false"
		border="false">
		<div class="datagrid-toolbar">
			<a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
				plain="true">添加</a>
			<a id="edit" icon="icon-edit" href="${pageContext.request.contextPath }/page_case_companyinfo.action" class="easyui-linkbutton"
				plain="true">公司信息操作</a>	
		</div>
	</div>
	<div region="center" style="overflow:auto;padding:5px;" border="false">
		<form id="noticebillForm" action="noticeBillAction_add.action" method="post">
			<table class="table-edit" width="95%" align="center">
				<tr class="title">
					<td colspan="4">公司信息</td>
				</tr>
				<tr>
					<td>公司名称:</td>
					<td><input type="text" class="easyui-validatebox" name="name"
						required="true" />
					</td>
				<tr>
					<td>公司地址:</td>
					<td><input type="text" class="easyui-validatebox"  name="address"
						required="true" /></td>
				</tr>
				<tr>
					<td>公司电话:</td>
					<td><input type="text" class="easyui-validatebox" name="phone"
						/></td>
					<td>公司传真:</td>
					<td><input type="text" class="easyui-validatebox" name="fax"
						 /></td>
				</tr>
				<tr>
					<td>联系人：</td>
					<td><input type="text" class="easyui-validatebox" name="linkman"
						required="true" /></td>
					<td>手机:</td>
					<td><input type="text" class="easyui-numberbox" name="telephone"
						required="true" /></td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td><input type="text" class="easyui-numberbox" name="email"
						 /></td>
					<td>网址:</td>
					<td><input type="text" class="easyui-validatebox" name="url"
						/></td>
				</tr>
				<tr>
					<td>QQ:</td>
					<td ><input type="text" class="easyui-validatebox" name="qq"
						required="true"/></td>
				</tr>
				<tr>
					<td>公司简介:</td>
					<td colspan="3"><textarea rows="5" cols="80" type="text" class="easyui-validatebox" name="induction
					"
						></textarea></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>