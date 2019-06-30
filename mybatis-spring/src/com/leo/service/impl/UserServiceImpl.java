package com.leo.service.impl;

import java.util.List;

import com.leo.dao.Userdao;
import com.leo.domain.User;
import com.leo.service.UserService;
/**
 * service
 * @author leoi555
 *
 */
public class UserServiceImpl implements UserService {
	private Userdao userDao;

	/**
	 * @return the userDao
	 */
	public Userdao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(Userdao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getListUser() {
		// TODO Auto-generated method stub
		return userDao.getListUser();
	}
}
