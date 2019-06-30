package com.leo.bos.dao.Impl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.leo.bos.dao.IStaffDao;
import com.leo.bos.dao.base.impl.BaseDaoImpl;
import com.leo.bos.domain.BcStaff;
/**
 * 
 * @author leoi555
 *
 */
@Repository
public class StaffDaoImpl extends BaseDaoImpl<BcStaff> implements IStaffDao{
	
	@Override
	public void deleteBatch(String id) {
		// TODO Auto-generated method stub
		String hql="UPDATE BcStaff set deltag=:deltag where id=:id";
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//3.创建session
		Session session=sessionFactory.getCurrentSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		Query query=session.createQuery(hql);
		////:2设置方式：
		query.setParameter("deltag", "1");
		query.setParameter("id", id);
			
		int i=query.executeUpdate();
		System.out.println("影响的行数："+i);
		beginTransaction.commit();
	}

	

}
