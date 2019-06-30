package com.leo.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.leo.dao.UserDao;
import com.leo.domain.User;
import com.leo.utils.HibernateUtil;
/**
 * 数据操作
 * @author leoi555
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User getByUserCode(String user_code) {
		// TODO Auto-generated method stub
		//1.获取session
		Session session=HibernateUtil.openSession();
		//2.hql语句
		String sql="from User where user_code=:code";
		//执行语句
		Query query = session.createQuery(sql);
		//设置参数
		query.setParameter("code", user_code);
		//执行查询
		User user = (User)query.uniqueResult();
		return user;
	}

}
