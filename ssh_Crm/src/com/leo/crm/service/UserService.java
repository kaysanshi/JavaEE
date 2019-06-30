package com.leo.crm.service;

import com.leo.crm.domain.User;

public interface UserService {
	/**
	 * 登录操作
	 * @param user
	 * @return
	 */
	User getUserBylogin(User user);

}
