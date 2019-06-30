package com.leo.bos.dao;

import com.leo.bos.dao.base.IBaseDao;
import com.leo.bos.domain.User;

/**
 * userDao接口
 * @author leoi555
 *
 */
public interface IUserDao extends IBaseDao<User>{
	/**
	 * 查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findUserByUsernameAndPassword(String username, String password);
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	void editPassword(String id, String password);
	User findUserByUsername(String username);

}
