package com.leo.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.leo.dao.UserDao;
/**
 * user
 * @author leoi555
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
		private SessionFactory sessionFactory;

}
