package com.leo.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.leo.springboot.domain.User;

/**
 * 使用mybatis实现对数据库的操作
 * @author leoi555
 *
 */
@Mapper
public interface UserMapper {
	//${value} value就是一个占位符
	@Select("select * from user where name like '%${value}%'")
	public List<User> queryUserByName(String name);
	@Select("select * from user")
	public List<User> getAll();
}
