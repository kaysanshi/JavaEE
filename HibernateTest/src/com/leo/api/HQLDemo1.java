package com.leo.api;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.leo.domain.Customer;

/**
 * 多表查询(不常用)
 * @author leoi555
 *
 */
public class HQLDemo1 {
	/**
	 * 笛卡尔积：select * from A,B
	 * 内连接：
	 * 		隐式：select * from A,B where a.id=b.id;
	 * 		显示：select * from A inner join B on a.id=b.id;
	 * 外链接：
	 * 		左连接：select * from A left [outer] join B on a.id=b.id;
	 * 			取A+(AB的交集)
	 * 		右连接：select * from A right [outer] join B on a.id=b.id;
	 * 			取B+(AB的交集)
	 */
	/**
	 * HQL连接：
	 * 		内连接(迫切)：
	 * 		外连接：
	 * 			左外(迫切)：
	 * 			右外(迫切)：
	 */
	/**
	 * 内连接--》把两个对象都放到数组中
	 */
	
	public void test1() {
		Session session=HibernateUtil.openSession();
		Transaction t=session.beginTransaction();
			String hql="from Customer c inner join c.linkMens";
			Query createQuery = session.createQuery(hql);
			List<Object[]> list=createQuery.list();
			for(Object[] obj1 : list) {
				System.out.println(Arrays.toString(obj1));
			}
			System.out.println(list);
		t.commit();
		session.close();
	}
	/**
	 * 迫切内连接---》用于封装对象
	 */
	@Test
	public void test2() {
		Session session=HibernateUtil.openSession();
		Transaction t=session.beginTransaction();
			String hql="from Customer c inner join fetch c.linkMens";
			Query createQuery = session.createQuery(hql);
			List<Customer> list=createQuery.list();			
			System.out.println(list);
		t.commit();
		session.close();
	}
	/**
	 * hq左外连接
	 */
	@Test
	public void test3() {
		Session session=HibernateUtil.openSession();
		Transaction t=session.beginTransaction();
			String hql="from Customer c left join fetch c.linkMens";
			Query createQuery = session.createQuery(hql);
			List<Customer> list=createQuery.list();			
			System.out.println(list);
		t.commit();
		session.close();
	}
	/**
	 * 右外连接
	 */
	@Test
	public void test4() {
		Session session=HibernateUtil.openSession();
		Transaction t=session.beginTransaction();
			String hql="from Customer c right join fetch c.linkMens";
			Query createQuery = session.createQuery(hql);
			List<Customer> list=createQuery.list();			
			System.out.println(list);
		t.commit();
		session.close();
	}
	
}
