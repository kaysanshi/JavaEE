<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/src/jquery.form.js"></script>
<script type="text/javascript">
	function doAdd(){
		//alert("增加...");
		$('#addStaffWindow').window("open");
	}
	
	function doView(){
		alert("查看...");
	}
	//删除按钮绑定的函数
	function doDelete(){
		alert("删除...");
		var rows=$("#grid").datagrid("getSelections");
		if(rows.length==0){
			//没用选中的时提示
			$.messager.alert("提示信息","请选择要删除的取派员!","warning");
			
		}else{
			//选中弹出确认框
			$.messager.alert("提示信息","确认删除吗?",function(r){
				if(r){
					var ids="";//可以拼接；ids+=id+",";但是最后会有一个逗号
					var array=new Array();
					//确定发送请求
					//获取所选中的取派员的id
					for(var id=0;i<rows.length;i++){
						var staff=row[i];//json对象
						var id=staff.id;//获取其中的id
						array.push(id);
					}
					var ids=array.join(",");//1,2,3,5
					//发送请求页面刷新
					loaction.href="staffAction_deleteBatch.action?ids";
					//发送请求页面不刷新
					//$.post("staffAction_deleteBatch.action?ids");
				}
			})
		}
	}
	
	function doRestore(){
		alert("将取派员还原...");
	}
	//工具栏
	var toolbar = [ {
		id : 'button-view',	
		text : '查询',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-delete',
		text : '删除',
		iconCls : 'icon-cancel',
		handler : doDelete
	},{
		id : 'button-save',
		text : '还原',
		iconCls : 'icon-save',
		handler : doRestore
	}];
	// 定义列
	var columns = [ [ {
		field : 'id',
		checkbox : true,
	},{
		field : 'name',
		title : '姓名',
		width : 120,
		align : 'center'
	}, {
		field : 'telephone',
		title : '手机号',
		width : 120,
		align : 'center'
	}, {
		field : 'haspda',
		title : '是否有PDA',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(data=="1"){
				return "有";
			}else{
				return "无";
			}
		}
	}, {
		field : 'deltag',
		title : '是否作废',
		width : 120,
		align : 'center',
		//后台存入数值然后在前台通过判断数字的形式来改变前台显示的文字
		formatter : function(data,row, index){
			if(data=="0"){
				return "正常使用"
			}else{
				return "已作废";
			}
		}
	}, {
		field : 'standard',
		title : '取派标准',
		width : 120,
		align : 'center'
	}, {
		field : 'station',
		title : '所谓单位',
		width : 200,
		align : 'center'
	} ] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 取派员信息表格装饰表格信息
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,//是否填充整个区域
			border : false,//是否有边框
			rownumbers : true,//显示编号
			striped : true,//纹理效果
			pageList: [30,50,100],//设置分页的数字
			pagination : true,
			toolbar : toolbar,//工具条
			url : "staffAction_pageQuery.action",
			idField : 'id',//获取id标示
			columns : columns,
			//绑定双击事件
			onDblClickRow : doDblClickRow
		});
		
		// 添加取派员窗口
		$('#addStaffWindow').window({
	        title: '添加取派员',
	        width: 400,
	        modal: true,//遮罩
	        shadow: true,//阴影
	        closed: true,//关闭
	        height: 400,
	        resizable:false //是否调大小
	    });
		//修改取派员
		$('#editStaffWindow').window({
        title: '添加取派员',
        width: 400,
        modal: true,//遮罩
        shadow: true,//阴影
        closed: true,//关闭
        height: 400,
        resizable:false //是否调大小
    });
		
	});
	//双击点击事件
	function doDblClickRow(rowIndex, rowData){
		$("#editStaffWindow").window("open");
		//alert(rowData.name);//可以获取选取的行的数据
		//回显子段名要和name属性相同
		$("#editStaffWindow").form("load",rowData);
	}
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<!-- 权限认证  与web.xml有关-->
	<shiro:hasPermission name="staff-delete">
		<!-- 这里面只要把相关的代码写到这里面包裹下就可以直接使用了 -->
	</shiro:hasPermission>
	
	<div region="center" border="false">
    	<table id="grid"></table>
	</div>
	<div class="easyui-window" title="对收派员进行添加或者修改" id="addStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="staffaddform" action="staffAction_add.action" method="post">
			
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr>
						<td>取派员编号</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td>
							<script>
								$(function(){
									$("#save").click(function(){
										var v=$("#staffaddform").form("validate");
										if(v){
											$("#staffaddform").submit();
										}
								
										
									});
									var reg=/^1[3|4|5|7|8][0-9]{9}$/;
									//扩展手机校验码
									$.extend($.fn.validatebox.defaults.rules,{
										telephone:{
											validator:function(value,param){
												return reg.test(value);
											},
											message:'手机号输入有误.'
										}
									})
								});
							</script>
						<input type="text" data-options="validType:'telephone'" name="telephone" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" value="1" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>
	<!-- 修改 页面------------------------------------------------->
	<div class="easyui-window" title="对收派员进行添加或者修改" id="editStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="staffeditform" action="${pageContext.request.contextPath }/staffAction_edit.action" method="post">
				<input type="hidden" name="id">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr>
						<td>取派员编号</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td>
							<script>
								$(function(){
									$("#save").click(function(){
										var v=$("#staffeditform").form("validate");
										if(v){
											$("#staffeditform").submit();
										}
								
										
									});
									var reg=/^1[3|4|5|7|8][0-9]{9}$/;
									//扩展手机校验码
									$.extend($.fn.validatebox.defaults.rules,{
										telephone:{
											validator:function(value,param){
												return reg.test(value);
											},
											message:'手机号输入有误.'
										}
									})
								});
							</script>
						<input type="text" data-options="validType:'telephone'" name="telephone" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" value="1" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>
</body>
</html>	