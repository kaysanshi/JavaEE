package com.leo.crm.service.impl;

import javax.management.RuntimeErrorException;

import com.leo.crm.dao.UserDao;
import com.leo.crm.domain.User;
import com.leo.crm.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User getUserBylogin(User user) {
		// TODO Auto-generated method stub
		//1.判断用户是否存在
			User user2=userDao.getUserByCode(user.getUser_code());
		//2.判断密码是否正确--》不正确提示密码错误
			if(user2==null) {
				throw new RuntimeException("用户名不存在");
			}
			if (!user2.getUser_password().equals(user.getUser_password())) {
				throw new RuntimeException("用户名密码不正确");
			}
		//3.返回用户对象
		return user2;
	}

}
