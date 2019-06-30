package com.leo.api;
/**
 * 离线查询
 * @author leoi555
 *
 */

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.leo.domain.Customer;
/**
 * 离线查询
 * @author leoi555
 *
 */
public class CriteriaDemo1 {
	public void fun() {
		
		//service层：
			DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
			dc.add(Restrictions.idEq(5l));//拼装条件
			/////
			Session session=HibernateUtil.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction(); 
		Criteria crei=dc.getExecutableCriteria(session);
		List<Customer> list=crei.list();
		System.out.println(list);
		beginTransaction.commit();
		session.close();
	}
}
