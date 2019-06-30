package com.leo.service;

import com.leo.domain.User;

public interface UserService {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);

}
