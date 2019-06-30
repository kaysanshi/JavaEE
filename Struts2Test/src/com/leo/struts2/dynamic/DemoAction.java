package com.leo.struts2.dynamic;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 动态调用
 * @author leoi555
 *
 */
public class DemoAction extends ActionSupport {
	
	public String add() {
		System.out.println("添加用户");
		return "success";
	}
	public String delete() {
		System.out.println("删除用户");
		System.out.println("删除用户");
		return "success";
	}
	public String update() {
		System.out.println("修改用户");
		return "success";
	}
	public String find() {
		System.out.println("查找用户");
		return "success";
	}

}
