package com.leo.crm.service;

import com.leo.crm.domain.User;

/**
 * user业务逻辑类
 * @author leoi555
 *
 */
public interface UserService {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);

}
