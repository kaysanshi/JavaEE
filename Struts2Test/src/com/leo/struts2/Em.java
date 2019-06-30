package com.leo.struts2;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
/**
 * 用注解的方式来映射
 * @author leoi555
 *
 */
@Results({
	   @Result(name="success", location="/success.jsp"),
	   @Result(name="input", location="/index.jsp")
	})
public class Em extends ActionSupport{
	private String name;
	   private int age;

	   @Action(value="/emp")
	   public String execute() 
	   {
	       return SUCCESS;
	   }

	   @RequiredFieldValidator( message = "The name is required" )
	   public String getName() {
	       return name;
	   }
	   public void setName(String name) {
	       this.name = name;
	   }

	   @IntRangeFieldValidator(message = "Age must be in between 28 and 65",
	                                      min = "29", max = "65")
	   public int getAge() {
	       return age;
	   }
	   public void setAge(int age) {
	       this.age = age;
	   }
}
