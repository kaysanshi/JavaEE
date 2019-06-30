package com.leo.api;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.leo.domain.Customer;
/**
 * hibernate自己的 用于多表查询但不复杂时用
 * @author leoi555
 *
 */

public class HQLDemo {
	//查询
	public void test1() {
			
			//1.创建
				Configuration cof=new Configuration().configure();
			//2.获得session工厂
				SessionFactory factory=cof.buildSessionFactory();
			//3.创建session
				Session session=factory.openSession();
			//4.开启事务
			Transaction beginTransaction = session.beginTransaction();
			//操作语句
			String hql="from Customer";
			//条件查询1：对应的对象的属性
			String hql1="from Customer where cust_id=?";
			//条件查询2：:id,是占位符，和站位符名字
			String hql2="from Customer where cust_id=:id";
			//创建查询对象
			Query query=session.createQuery(hql);
			//:1设置方式：是从下表为0的
				query.setParameter(0, 1l);
			////:2设置方式：
				query.setParameter("id", 1l);
			//单个值：
			//query.uniqueResult();
			//多个对象的形式
			List<Customer> list = query.list();
			System.out.println(list);
			beginTransaction.commit();
			session.close();//托管状态
			factory.close();
		}
	/**
	 * 分页查询
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
		//操作语句
		String hql="from Customer";
		Query createQuery = session.createQuery(hql);
		//设置分页信息
		createQuery.setFirstResult(0);
		createQuery.setMaxResults(3);
		List<Customer> list = createQuery.list();
		System.out.println(list);
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
	/**
	 * 排序
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
			//操作语句
			String hql="from Customer order by cust_id asc";
			Query createQuery = session.createQuery(hql);
			List<Customer> list = createQuery.list();
			System.out.println(list);
			beginTransaction.commit();
			session.close();//托管状态
			factory.close();
	}	
	/**
	 * 条件查询
	 */
	public void test4() {
		//1.创建
			Configuration cof=new Configuration().configure();
		//2.获得session工厂
			SessionFactory factory=cof.buildSessionFactory();
		//3.创建session
			Session session=factory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		String sql="select * from  Customer where cust_id=?";
		Query query=session.createSQLQuery(sql);
		query.setParameter(0,1l);
		//指定将结果封装到哪个实体中；
		List<Customer> list=query.list();
		System.out.println(list);
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
	/**
	 * 统计查询
	 * count,avg,max,min,sum函数查询
	 */
	public void test5() {
		//1.创建
			Configuration cof=new Configuration().configure();
		//2.获得session工厂
			SessionFactory factory=cof.buildSessionFactory();
		//3.创建session
			Session session=factory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		String sql="select count(*) from  Customer";
		Query query=session.createSQLQuery(sql);
		//用Number类型来接受
		Number count=(Number) query.uniqueResult();
		System.out.println(count);
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
	/**
	 * 投影查询
	 */
	public void test6() {
		//1.创建
			Configuration cof=new Configuration().configure();
		//2.获得session工厂
			SessionFactory factory=cof.buildSessionFactory();
		//3.创建session
			Session session=factory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		//new Customer(cust_id,cust_name);要加入构造方法，和空参构造
		String sql="select new Customer(cust_id,cust_name) from  Customer";
		Query query=session.createSQLQuery(sql);
		//用Number类型来接受
		Number count=(Number) query.uniqueResult();
		System.out.println(count);
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
}
