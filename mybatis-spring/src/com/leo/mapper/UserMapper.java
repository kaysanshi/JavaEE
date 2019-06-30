package com.leo.mapper;

import java.util.List;

import com.leo.domain.User;

/**
 * mapper动态代理开发
 * @author leoi555
 *
 */
public interface UserMapper {
	/**
	 * 查找的方法
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id); 
	public List<User> getListUser();
}
