package com.baizhi.cooler.service;

import com.baizhi.cooler.domain.Admin;

/**
 * 
 * @author leoi555
 *
 */
public interface UserService {
	/**
	 * 用户名密码是否正确
	 * @param model
	 * @return
	 */
	Admin checkLogin(Admin model);
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	void editPassword(String id, String password);

}
