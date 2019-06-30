package com.leo.bos.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.leo.bos.dao.IUserDao;
import com.leo.bos.dao.base.impl.BaseDaoImpl;
import com.leo.bos.domain.User;
/**
 * user操作
 * @author leoi555
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String hql="From User u where u.username=:username and u.password=:password ";
	
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//3.创建session
		Session session=sessionFactory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		Query query=session.createQuery(hql);
		////:2设置方式：
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<User> list = query.list();
		if (list !=null &&list.size()>0) {
			return list.get(0);
		}
		beginTransaction.commit();
		return null;
	}

	@Override
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		String hql="UPDATE User set password=:password where id=:id";
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//3.创建session
		Session session=sessionFactory.getCurrentSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		Query query=session.createQuery(hql);
		////:2设置方式：
		query.setParameter("password", password);
		query.setParameter("id", id);
			
		int i=query.executeUpdate();
		System.out.println("影响的行数："+i);
		beginTransaction.commit();
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String hql="From User u where u.username=:username";
			
				SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
				//3.创建session
				Session session=sessionFactory.openSession();
				//4.开启事务
				Transaction beginTransaction = session.beginTransaction();
				Query query=session.createQuery(hql);
				////:2设置方式：
					query.setParameter("username", username);
					List<User> list = query.list();
				if (list !=null &&list.size()>0) {
					return list.get(0);
				}
				beginTransaction.commit();
				return null;
	}

}
