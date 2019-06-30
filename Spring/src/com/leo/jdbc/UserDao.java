package com.leo.jdbc;

import java.util.List;

import com.leo.domain.User;

/**
 * 
 * @author leoi555
 *
 */
public interface UserDao {
	/**
	 * 增加
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 删除
	 * @param id
	 */
	void deleteUser(int id);
	/**
	 * 修改
	 */
	void updateUser(User user);
	/**
	 * 获取user对象
	 * @param id
	 * @return
	 */
	User getUserbyId(Integer id);
	/**
	 * 获得总的行数
	 * @return
	 */
	int getTotalCount();
	/**
	 * 
	 * @return
	 */
	List<User>getAllUser();
}
