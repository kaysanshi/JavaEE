package com.leo.struts2;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 验证机制
 * @author leoi555
 *	当用户按下提交按钮时，Struts2 将自动执行validate方法，如果方法中列出的任何if语句为真，
 *	Struts2 将调用addFieldError方法。如果添加了任何错误信息，Struts2 将不会调用execute方法。
 *	否则，Struts2 框架将返回input作为调用操作的结果。
	因此，当验证失败并且Struts2 返回input时，Struts2 框架将重新显示index.jsp文件。
	这些错误信息是我们在addFieldError方法调用中指定的信息。
	addFieldError方法接受两个参数，第一个是出错时应用的form字段名称，
	第二个是在form字段上方显示的错误信息。
 */
public class EmployeeAction extends ActionSupport {
	 private String name;
	   private int age;
	   
	   public String execute() 
	   {
	       return SUCCESS;
	   }
	   public String getName() {
	       return name;
	   }
	   public void setName(String name) {
	       this.name = name;
	   }
	   public int getAge() {
	       return age;
	   }
	   public void setAge(int age) {
	       this.age = age;
	   }
	   
	   public void validate()
	   {
	      if (name == null || name.trim().equals(""))
	      {
	    	  //验证机制addfieldError用于验证
	         addFieldError("name","The name is required");
	      }
	      if (age < 28 || age > 65)
	      {
	         addFieldError("age","Age must be in between 28 and 65");
	      }
	   }
}
