package com.leo.action;

import com.leo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Maven项目中使用action即struts
 * @author leoi555
 *
 */
public class UserAction extends ActionSupport{
	private Long user_id;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("获得id:"+user_id);
		return "success";
	}
	public String deleteUser() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("删除id:"+user_id);
		return "success";
	}
	public String findUser() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("查找id:"+user_id);
		return "success";
	}
	
}
