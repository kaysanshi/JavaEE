package com.leo.service.impl;

import com.leo.dao.UserDao;
import com.leo.dao.impl.UserDaoImpl;
import com.leo.domain.User;
import com.leo.service.UserService;
import com.leo.utils.HibernateUtil;

public class UserServiceImpl implements UserService {
	private UserDao dao=new UserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//打开事务
		HibernateUtil.getCurrentsesion().beginTransaction();
		//1.数据库中是否有这个数据
		User user2=dao.getByUserCode(user.getUser_code());
		//提交事务
		HibernateUtil.getCurrentsesion().getTransaction().commit();
		if (user2==null) {
			throw new RuntimeException("用户名不存在");
		}
		//2.比对密码
		if (!user2.getUser_password().equals(user.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		return user2;
	}
	
}
