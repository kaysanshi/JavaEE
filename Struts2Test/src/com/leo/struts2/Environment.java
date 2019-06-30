package com.leo.struts2;
/**
 * 基类
 * @author leoi555
 *
 */
public class Environment {
		private String name;
	   public  Environment(String name)
	   {
	      this.name = name;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
}
