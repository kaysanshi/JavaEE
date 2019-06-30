package com.leo.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.leo.springboot.dao.UserDao;
import com.leo.springboot.dao.UserMapper;
import com.leo.springboot.domain.User;
import com.leo.springboot.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;//springjpa
	
	/**
	 * 使用代理mapper创建dao层
	 * 
	 */
	@Autowired
	private UserMapper mapper;
	
	@Override
	//使用redis缓存
	@Cacheable(value=" ",key="''")
		//value属性:表示存入Redis数据库中的key
		//key属性：表示执行方法返回值得key,该属性是spring用的，不写也有默认值为空
	public List<User> getAll(String name) {
		// TODO Auto-generated method stub
		return mapper.queryUserByName(name);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return mapper.getAll();
	}
}
