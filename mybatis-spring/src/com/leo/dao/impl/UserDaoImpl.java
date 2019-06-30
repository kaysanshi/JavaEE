package com.leo.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.leo.dao.Userdao;
import com.leo.domain.User;
/**
 * 原始的dao
 * @author leoi555
 *
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements Userdao {

	@Override
	public List<User> getListUser() {
		// TODO Auto-generated method stub
		List<User> selectList = this.getSqlSession().selectList("test.getListUser");
		for (User user : selectList) {
			System.out.println(user);
		}
		return null;
	}
		
	
}
