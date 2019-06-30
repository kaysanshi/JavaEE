package com.baizhi.cooler.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baizhi.cooler.dao.UserDao;
import com.baizhi.cooler.domain.Admin;
import com.baizhi.cooler.service.UserService;
import com.baizhi.cooler.utils.MD5Utils;
/**
 * 
 * @author leoi555
 *
 */

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	/**
	 * @param userDao the userDao to set
	 */
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Admin checkLogin(Admin user) {
		// TODO Auto-generated method stub
		//md5加密
		String password=MD5Utils.md5(user.getPassword());
		return userDao.checkLoginUser(user.getUsername(),password);
	}

	@Override
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		password=MD5Utils.md5(password);
		userDao.editPassword(id,password);
	}
}
