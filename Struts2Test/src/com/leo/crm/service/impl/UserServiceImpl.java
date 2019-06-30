package com.leo.crm.service.impl;

import com.leo.crm.dao.UserDao;
import com.leo.crm.dao.impl.UserDaoImpl;
import com.leo.crm.domain.User;
import com.leo.crm.service.UserService;
/**
 * user业务逻辑层
 * @author leoi555
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao dao=new UserDaoImpl();

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}
}
