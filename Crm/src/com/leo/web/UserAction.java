package com.leo.web;

import com.leo.domain.User;
import com.leo.service.UserService;
import com.leo.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService service=new UserServiceImpl();
	private User user=new User();
	
	public String login() {
		User us=service.login(user);
		ActionContext.getContext().getSession().put("user", us);
		return "toHome";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
