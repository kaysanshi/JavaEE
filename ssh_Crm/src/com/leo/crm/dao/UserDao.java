package com.leo.crm.dao;

import com.leo.crm.domain.User;

public interface UserDao {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User getUserBylogin(User user);
	/**
	 * 查询是否有这个用户
	 * @param user_code
	 * @return
	 */
	User getUserByCode(String user_code);

}
