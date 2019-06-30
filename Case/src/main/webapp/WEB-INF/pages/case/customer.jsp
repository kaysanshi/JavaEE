<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人工调度</title>
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
	$(function() {
		$("#grid").datagrid({
			singleSelect : true,
			toolbar : [ {
				id : 'kehu',
				text : '客户添加',
				iconCls : 'icon-add',
				handler : function() {
					// 弹出窗口
					$("#customerWindow").window('open');
				}
			} ],
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 100
			}, {
				field : 'title',
				title : '标题',
				width : 100
			}, {
				field : 'context',
				title : '内容',
				width : 100
			}, {
				field : 'gender',
				title : '性别',
				width : 100
			}, {
				field : 'email',
				title : '邮箱',
				width : 100
			}, {
				field : 'telephone',
				title : '手机',
				width : 100
			},{
				field : 'phone',
				title : '电话',
				width : 100
			},{
				field : 'company_name',
				title : '公司名称',
				width : 100
			},{
				field : 'address',
				title : '地址',
				width : 100
			},{
				field : 'addtime',
				title : '时间',
				width : 100,
				formatter : function(data, row, index) {
					return data.replace("T", " ");
				}
			} ] ],
			//这个是加载的请求的路径，请求是分页list列表
			url : '${pageContext.request.contextPath}/customerAction_pageQuerylist.action'
		});

		// 点击保存然后直接提交
		$("#save").click(function() {
			var v=$("#customerForm").form("validate");
			if(v){
				$("#customerForm").submit();
			}
		});
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
		<table id="grid"></table>
	</div>
	<div class="easyui-window" title="客户添加" id="customerWindow" closed="true"
		collapsible="false" minimizable="false" maximizable="false"
		style="top:100px;left:200px;width: 500px; height: 300px">
		<div region="north" style="height:31px;overflow:hidden;" split="false"
			border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
					plain="true">保存</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="customerForm" method="post" action="customerAction_add.action">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">客户添加</td>
					</tr>
					<tr>
						<td><input type="hidden" name="customerid" id="cusomerid" /> </span>
					</tr>
					<tr>
						<td>客户姓名</td>
						<td><input type="text" class="easyui-validatebox" name="name"/></td>
					</tr>
					<tr>
						<td>客户手机</td>
						<td><input type="text" class="easyui-validatebox" name="telephone"/></td>
					</tr>
					<tr>
						<td>客户电话</td>
						<td><input type="text" class="easyui-validatebox" name="phone"/></td>
					</tr>
					<tr>
						<td>客户地址</td>
						<td><input type="text" class="easyui-validatebox" name="address"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>