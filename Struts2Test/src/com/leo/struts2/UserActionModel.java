package com.leo.struts2;

import java.util.Iterator;

import org.apache.catalina.Group;
import org.apache.catalina.Role;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 驱动模型
 * @author leoi555
 *
 */
public class UserActionModel extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	//
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
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
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
