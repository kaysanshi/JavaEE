package com.leo.service;
/**
 * 数据操作层
 * @author leoi555
 *
 */

import java.util.List;

import com.leo.domain.User;

public interface UserService {
	
	/**
	 *查询
	 */
	public List<User> getListUser();
 }
