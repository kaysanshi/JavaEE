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

<title>添加新闻</title>

<script type="text/javascript">
		//简化获取ID
	     function $(id){
		    return document.getElementById(id);
		 }

       // <!--验证提交表单-->
		function validatePost(){
			  
			  
			  if(validateField($("title"),'新闻标题')==true && validateField($("picture"),'新闻封面')==true && validateField($("addtime"),'上传时间')){
			      //如果全部通过，则提交表单
			      var content=GetContents();
			      if(content!=null && content!=""){
			        $("form").submit();	
			      }else{
			        alert('新闻内容为空');
			      }
			      	  
			  }		 
			
		}
		
		//验证字段
		function validateField(name,tip){
		   
		       if(name.value==""){
			      alert(tip+'不能为空');
				  name.focus();
				  return false;
			   }else{
			      return true;
			   }
		
		}
		
	
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
	
	
	//获取CKEditor控件中的内容
		function GetContents()
		{		
			var content = CKEDITOR.instances.content;	
			return content.getData();
		}
		
		//跳转取消界面
		function esc()

        {

        window.location("display.jsp");

        }
		
</script>

<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

</head>
<body>
	<div>
		<div>${message}</div>
		<div>
			<form id="form" action="/zznews/newsServlet?action=publish"
				method="post">
				<table cellspacing="0" cellpadding="0" width=“100”>

					<tr>
						<td><label>新闻标题：</label> <input type="text" id="title"
							name="title" style="width: 20%;" /></td>
					</tr>

					<tr>
						<td><label>新闻类别：</label> <select id="categoryid"
							name="categoryid" style="color: #999; opacity: 1;">
								<c:forEach items="${records}" var="record">
									<option value="${record.categoryid}">${record.name}</option>
								</c:forEach>
						</select></td>
					</tr>


					<tr>
						<td><label>新闻作者：</label> <input type="text" id="userid"
							name="userid" style="width: 5%;" /></td>
					</tr>


					<tr>
						<td><label>新闻封面：</label> <input id="picture" type="text"
							name="picture"> <input type="button" value="上传封面"
							onclick="openWindow('news/upload.jsp','上传文件',500,200,0);">
						</td>
					</tr>

					<tr>
						<td><label>添加时间：</label> <input type="text" id="addtime"
							name="addtime"
							onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><textarea id="content" name="content" rows="400"
								cols="300"></textarea> <script type="text/javascript">
					       CKEDITOR.replace('content');
		              </script></td>
					</tr>

					<tr>
						<td><input type="button"
							style="width: 80px; height: 30px; background-color: #32CD32; color: #FFF;"
							value="上传" onClick="validatePost()" /> <input type="button"
							style="width: 80px; height: 30px; background-color: #e0e0e0; color: #FFF;"
							value="取消" onclick="esc()" /></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
</body>
</html>
