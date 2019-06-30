package com.leo.api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.leo.domain.Customer;

/**
 * 无语句查询,单表查询
 * @author leoi555
 *
 */
public class CriteriaDemo {
		
		/**
		 * 查询全部
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
			Criteria crei=session.createCriteria(Customer.class);//查询所有的Customer对象
			List<Customer> list=crei.list();
			System.out.println(list);
			beginTransaction.commit();
			session.close();//托管状态
			factory.close();
		}
		/**
		 * 条件查询
		 *会的查询到的对象直接封装到对象中
		 */
		@Test
		public void test2() {
				
				//1.创建
					Configuration cof=new Configuration().configure();
				//2.获得session工厂
					SessionFactory factory=cof.buildSessionFactory();
				//3.创建session
					Session session=factory.openSession();
				//4.开启事务
				Transaction beginTransaction = session.beginTransaction();
				Criteria crei=session.createCriteria(Customer.class);//
				//添加查询，查询cust_id为1的对象
				crei.add(Restrictions.eq("cust_id", 5l));
				Customer uniqueResult = (Customer) crei.uniqueResult();
				System.out.println(uniqueResult);
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
			Criteria crei=session.createCriteria(Customer.class);//
			//设置分页参数
			crei.setFirstResult(0);
			crei.setMaxResults(2);
			List<Customer> list = crei.list();
			System.out.println(list);
			beginTransaction.commit();
			session.close();//托管状态
			factory.close();
		}
		/**
		 * 查询总记录数
		 */
		@Test
		public void getCount(){
			//1.创建
				Configuration cof=new Configuration().configure();
			//2.获得session工厂
				SessionFactory factory=cof.buildSessionFactory();
			//3.创建session
				Session session=factory.openSession();
			//4.开启事务
			Transaction beginTransaction = session.beginTransaction();
			Criteria crei=session.createCriteria(Customer.class);//
			//设置查询的聚合函数
			crei.setProjection(Projections.rowCount());
			Long count=(Long)crei.uniqueResult();
			System.out.println(count);
			List<Customer> list = crei.list();
			System.out.println("数据量为："+list.size());
			beginTransaction.commit();
			session.close();//托管状态
			factory.close();
		}
}
