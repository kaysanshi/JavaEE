package com.baizhi.cooler.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.baizhi.cooler.dao.UserDao;
import com.baizhi.cooler.dao.base.impl.BaseDaoImpl;
import com.baizhi.cooler.domain.Admin;
/**
 * 
 * @author leoi555
 *
 */

public class UserDaoImpl extends BaseDaoImpl<Admin> implements UserDao {

	@Override
	public Admin checkLoginUser(String username, String password) {
		// TODO Auto-generated method stub
		String hql="From Admin a where a.username=:username and a.password=:password ";
		
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//3.创建session
		Session session=sessionFactory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		Query query=session.createQuery(hql);
		////:2设置方式：
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Admin> list = query.list();
		if (list !=null &&list.size()>0) {
			return list.get(0);
		}
		beginTransaction.commit();
		
		return null;
	}

	@Override
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		String hql="update Admin set password=:password where id=:id";
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		beginTransaction.begin();
		Query createQuery = session.createQuery(hql);
		createQuery.setParameter("password", password);
		createQuery.setParameter("id", id);
		int param = createQuery.executeUpdate();
		System.out.println("更新的行数：" +param );
		beginTransaction.commit();
	}

}
