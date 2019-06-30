package com.leo.api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.leo.domain.Customer;
/**
 * 原生的查询
 * @author leoi555
 *
 */
public class SqlDemo {
	/**
	 * 查询
	 */
	public void test1() {
		//1.创建
			Configuration cof=new Configuration().configure();
		//2.获得session工厂
			SessionFactory factory=cof.buildSessionFactory();
		//3.创建session
			Session session=factory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		String sql="select * from  customer";
		SQLQuery query=session.createSQLQuery(sql);
		//指定将结果封装到哪个实体中；
		query.addEntity(Customer.class);
		List<Customer> list=query.list();
//		List<Object[]> list = query.list();
//		for(Object obj: list) {
//			System.out.println(obj);
//		}
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
	/**
	 * 条件查询
	 */
	public void test2() {
		//1.创建
			Configuration cof=new Configuration().configure();
		//2.获得session工厂
			SessionFactory factory=cof.buildSessionFactory();
		//3.创建session
			Session session=factory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		String sql="select * from  customer where cust_id=?";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter(0,1l);
		//指定将结果封装到哪个实体中；
		query.addEntity(Customer.class);
		List<Customer> list=query.list();
		System.out.println(list);
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
	/**
	 * 分页
	 */
	public void test3() {
		//1.创建
			Configuration cof=new Configuration().configure();
		//2.获得session工厂
			SessionFactory factory=cof.buildSessionFactory();
		//3.创建session
			Session session=factory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		String sql="select * from  customer limit ?,?";
		SQLQuery query=session.createSQLQuery(sql);
		//前三页
		query.setParameter(0,0);
		query.setParameter(1, 2);
		//指定将结果封装到哪个实体中；
		query.addEntity(Customer.class);    
		List<Customer> list=query.list();
		System.out.println(list);
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
}
