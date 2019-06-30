package com.leo.crm.dao;

import com.leo.crm.domain.User;

public interface UserDao {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);

}
