package com.leo.hibernate;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.leo.domain.User;
import com.leo.jdbc.UserDao;
/**
 * 通过用Spring提供的
 * @author leoi555
 *
 */
public class UserDaoImplByHibernateSupport extends HibernateDaoSupport implements UserDao{
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=getHibernateTemplate().getSessionFactory();
		Session session=sessionFactory.openSession();
		User user=session.get(User.class, 3);//
		session.delete(user);//
		System.out.println("删除成功");
		session.close();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserbyId(Integer id) {
		// TODO Auto-generated method stub
		//执行查询
//		return getHibernateTemplate().execute(new HibernateCallback<User>() {
//
//			@Override
//			public User doInHibernate(Session session) throws HibernateException {
//				// TODO Auto-generated method stub
//				String hql="from User where id=?";
//				Query<User> createQuery = session.createQuery(hql);
//				createQuery.setParameter(0, id);
//				User user = createQuery.uniqueResult();
//				return user;
//			}
//		});
		//用criteria查询
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id",id));
		List<User> list=(List<User>) getHibernateTemplate().findByCriteria(dc);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
