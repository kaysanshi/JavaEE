package com.leo.crm.action;

import com.leo.crm.domain.User;
import com.leo.crm.service.UserService;
import com.leo.crm.service.impl.UserServiceImpl;
import com.leo.struts2.LoginAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 管理员的action
 * @author leoi555
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	private UserService service=new UserServiceImpl();
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User Login(User user) {
		User user2=service.login(user);
		return user2;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
