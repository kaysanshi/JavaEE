package com.leo.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.leo.domain.Customer;

/**
 * configuration对象：加载配置文件的类，加载实体，orm，配置映射文件
 * SessionFactory:用于获取核心对象session对象操作
 * 用SessionFactoty来创建session打开一个新的session对象sFactory.openSession();
 * Session:是一个会话，框架与数据库之间的链接，；类似于Connection对象，
 * 1.完成数据库的增删改查，2.核心对象
 * @author leoi555
 *持久化---》delete-->瞬时状态
	托管---》update--->持久化状态
	瞬时---》save---->持久化状态
	get--->持久化状态
 */
public class Demo {
	/**
	 * 基本的使用
	 */
	public void test() {
		//1.创建
		Configuration con=new Configuration();
		//2.读取配置文件==>空参加载时加载的src下的hibernate.cfg.xml文件
		con.configure();
		//3.读取映射文件基本上不用，读取的为.property,主配置文件引入后就不需要用这个方法了
		//con.addResource(resourceName);con.addClass(persistentClass);
		//4.构建SessionFactory对象、用于获取session对象操作数据库的核心对象
		SessionFactory sFactory=con.buildSessionFactory();
		//5.用SessionFactoty来创建session打开一个新的session对象
		Session session=sFactory.openSession();
		//获得一个与线程绑定的Session
		//sFactory.getCurrentSession();
		//6.事务的操作.获得操作事务的对象
		//Transaction sTransaction=session.getTransaction();
		//获得事务并开启事务(常用)
		Transaction sTransaction2=session.beginTransaction();
		sTransaction2.commit();//提交事务
		sTransaction2.rollback();//事务回滚
		session.close();
		sFactory.close();
	}
	
	//查询
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
		//操作语句
		Customer customer=session.get(Customer.class, 1L);
		System.out.println(customer);
		beginTransaction.commit();
		session.close();
		factory.close();
	}
	//修改
	/**
	 * 持久化状态对象的任何变化都会同步到数据库中
	 * 其实update就是把托管状态对象变为持久化状态对象；
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
		//操作语 先获得这个对象然后在修改
		Customer customer=session.get(Customer.class, 1l);//持久化状态对象
		customer.setCust_name("123");//这时就会执行更新语句
		session.update(customer);//
		System.out.println(customer);
		beginTransaction.commit();
		session.close();
		factory.close();
	}
	/**
	 *
	 */
	//删除
	public void test4() {
		
		//1.创建
			Configuration cof=new Configuration().configure();
		//2.获得session工厂
			SessionFactory factory=cof.buildSessionFactory();
		//3.创建session
			Session session=factory.openSession();
		//4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		//操作语 先获得这个对象然后在修改
		Customer customer=session.get(Customer.class, 1l);//
		session.delete(customer);//
		System.out.println(customer);
		beginTransaction.commit();
		session.close();
		factory.close();
	}
	//增加
	/**
	 * save只是把瞬时状态变为持久状态
	 * 主键自增，必须生成id并执行insert语句
	 * increment:执行save会查询执行sql id最大值得策略
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
		//操作语句
		Customer customer=new Customer();//瞬时状态 无id未与session关联
		customer.setCust_name("zhang");//状态未改变
		session.save(customer);//持久化状态有 id
		beginTransaction.commit();
		session.close();//托管状态
		factory.close();
	}
}
