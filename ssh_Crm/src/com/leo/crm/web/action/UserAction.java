package com.leo.crm.web.action;

import com.leo.crm.domain.User;
import com.leo.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * userAction用于操作user对象
 * @author leoi555
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user;
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String login() {
		System.out.println("登录");
		//1.调用service
		User users =userService.getUserBylogin(user); 
		//2.将返回的user放入session域
		ActionContext.getContext().getSession().put("user", users);
		//3.重定向到首页
		return "toHome";
	}
}
