package com.baizhi.cooler.dao;

import com.baizhi.cooler.dao.base.BaseDao;
import com.baizhi.cooler.domain.Admin;
/**
 * userDao
 * @author leoi555
 *
 */
public interface UserDao extends BaseDao<Admin>{
	/**
	 * 检查登录
	 * @param username
	 * @param password
	 * @return
	 */
	Admin checkLoginUser(String username, String password);
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	void editPassword(String id, String password);

}
