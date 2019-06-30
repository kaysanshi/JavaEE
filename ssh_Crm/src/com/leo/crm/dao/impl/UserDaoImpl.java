package com.leo.crm.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leo.crm.dao.UserDao;
import com.leo.crm.domain.User;
/**
 * user的操作
 * @author leoi555
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	 
	@Override
	public User getUserByCode(String user_code) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql="from User where user_code=?";
				Query query=session.createQuery(hql);
				query.setParameter(0, user_code);
				User user=(User) query.uniqueResult();
				return user;
			}
		});
	}
	
	@Override
	public User getUserBylogin(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
