package com.leo.springboot.service;
/**
 * 
 * @author leoi555
 *
 */

import java.util.List;

import com.leo.springboot.dao.UserDao;
import com.leo.springboot.domain.User;

public interface UserService {
	
	List<User> getAll(String name);
	/**
	 * 
	 * @return
	 */
	List<User> getAll();
}
