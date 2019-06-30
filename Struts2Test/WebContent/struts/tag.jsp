<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form表单标签</title>
<s:head/>
</head>
<body>
<!-- -，s:div和s:text元素。s:div用于呈现HTML Div元素。这对于不喜欢将HTML和Struts标签混合在一起的人很有用，他们可选择使用s:div来渲染div。 -->
	
   <s:text name="Please fill in the form below:" />
   <s:form action="hello" method="post" enctype="multipart/form-data">
  <!-- 表单隐藏项 -->
   <s:hidden name="secret" value="abracadabra"/>
   <s:textfield key="email.from" name="from" />
   <s:password key="email.password" name="password" />
   <s:textfield key="email.to" name="to" />
   <s:textfield key="email.subject" name="subject" />
   <s:textarea key="email.body" name="email.body" />
   <s:label for="attachment" value="Attachment"/>
   <s:file name="attachment" accept="text/html,text/plain" />
   <s:token />
   <!-- 单选框 -->
   <s:radio label="Gender" name="gender" list="{'male','female'}" />
   <!-- 复选框 -->
   <s:checkboxlist label="Hobbies" name="hobbies"
   list="{'sports','tv','shopping'}" />
  	<!-- 下拉框标签 -->
    <s:select name="username" label="Username"
         list="{'Mike','John','Smith'}" />

      <s:select label="Company Office" name="mySelection"
         value="%{'America'}"
         list="%{#{'America':'America'}}">
      <s:optgroup label="Asia" 
         list="%{#{'India':'India','China':'China'}}" />
      <s:optgroup label="Europe"
         list="%{#{'UK':'UK','Sweden':'Sweden','Italy':'Italy'}}" />
      </s:select>

      <s:combobox label="My Sign" name="mySign"
         list="#{'aries':'aries','capricorn':'capricorn'}"
         headerKey="-1" 
         headerValue="--- Please Select ---" emptyOption="true"
         value="capricorn" />
      <s:doubleselect label="Occupation" name="occupation"
         list="{'Technical','Other'}" doubleName="occupations2"
         doubleList="top == 'Technical' ? 
         {'I.T', 'Hardware'} : {'Accounting', 'H.R'}" />
       <!--Ajax标签 struts2-dojo-plugin-2.2.3.jar -->
        
   <s:submit key="submit" />
   </s:form>
</body>
</html>