package com.leo.dao;

import com.leo.domain.User;

/**	
 * 数据操作
 * @author leoi555
 *
 */
public interface UserDao {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User getByUserCode(String user_code);
	
}
