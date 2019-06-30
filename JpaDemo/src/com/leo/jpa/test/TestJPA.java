package com.leo.jpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.leo.jpa.Customer;
import com.leo.jpa.Order;

public class TestJPA {
	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	@Before
	public void intit() {
		factory=Persistence.createEntityManagerFactory("JpaDemo");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
	}
	@After
	public void destory() {
		transaction.commit();
		manager.close();
		factory.close();
	}
	//类似于hibernate中的saveOrUpdate方法：
	@Test
	public void testMerge1() {
		Customer customer=new Customer();
		customer.setAge("12");
		customer.setEmail("1233@163.com");
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setLastName("ccc");
		//manger是会先创建出来一个新的对象，把临时对象的属性复制到新的对象中
		//新的对象中会有id但是以前的临时对象中没有id;
		Customer customer2 = manager.merge(customer);
		
		System.out.println("customer#id:"+customer.getId());
		System.out.println("customer2#id:"+customer2.getId());
	}
	/**
	 * 传入的是游离对象即有对象的id
	 * 若在缓存中没有对象
	 * 在数据库中也没有对应的记录
	 * JPA会创建一个对象，然后把游离的对象复制到新创建的对象
	 * 执行insert对象
	 */
	@Test
	public void testMerge2() {
		Customer customer=new Customer();
		customer.setAge("12");
		customer.setEmail("dd@163.com");
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setLastName("ddd");
		customer.setId(100);
		Customer customer2 = manager.merge(customer);
		
		System.out.println("customer#id:"+customer.getId());
		System.out.println("customer2#id:"+customer2.getId());
	}
	/**
	 * 传入的是游离对象即有对象的id
	 * 若在缓存中没有对象
	 * 在数据库中有对应的记录
	 * JPA会查询对应的记录，然后返回该记录的一个对象再然后把游离的对象的属性复制到查询到的对象中
	 * 执行update
	 */
	@Test
	public void testMerge3() {
		Customer customer=new Customer();
		customer.setAge("12");
		customer.setEmail("dd@163.com");
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setLastName("ddd");
		customer.setId(2);
		Customer customer2 = manager.merge(customer);
		System.out.println(customer==customer2);
		System.out.println("customer#id:"+customer.getId());
		System.out.println("customer2#id:"+customer2.getId());
	}
	/**
	 * 传入的是游离对象即有对象的id
	 * 若在缓存中有对象
	 * JPA会把游离的对象的属性复制到缓存中的对象
	 * 对缓存中的对象执行update
	 */
	@Test
	public void testMerge4() {
		Customer customer=new Customer();
		customer.setAge("12");
		customer.setEmail("dd@163.com");
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setLastName("ddd");
		customer.setId(4);
		//这个是查询出的
		Customer customer2 = manager.find(Customer.class, 4);
		manager.merge(customer);
		System.out.println(customer==customer2);//false
		System.out.println("customer#id:"+customer.getId());
		System.out.println("customer2#id:"+customer2.getId());
	}
	
	//类似于hibernate中session的load方法
	@Test
	public void  getRefe() {
		// TODO Auto-generated method stub
		Customer customer=manager.find(Customer.class, 1);
		System.out.println("---");
		System.out.println(customer.getClass().getName());
	}
	//类似于hibernate 中的session的get方法
	@Test
	public void testFind() {
		Customer customer=manager.find(Customer.class, 1);
		System.out.println("---");
		System.out.println(customer);
	}
	//类似于hibernate中的save方法若对象中的有设置id则会出现异常错诶，不能执行insert方法
	@Test
	public void testPersistence() {
		Customer customer=new Customer();
		customer.setAge("11");
		customer.setEmail("12233@163.com");
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		manager.persist(customer);
		System.out.println(customer.getId());
	}
	//类似于hibernate的delete方法，把对象对应的记录从数据库中移除
	//该方法只能移除持久化的对象，不能移除游离对象
	public void testDelete() {
		//这样会报错
//		Customer customer=new Customer();
//		Hibernate中可以这样使用
//		manager.remove(customer);
		//
		Customer customer=manager.find(Customer.class, 1);
		manager.remove(customer);
	}
	//和hibernate中的session的flush方法一致
	@Test
	public void testFlush() {
		Customer customer=manager.find(Customer.class, 1);
		System.err.println(customer);
		customer.setLastName("AA");
		//强制发送一条sql让缓存中的数据和数据库中的一致
		manager.flush();
	}
	/**
	 * 保存多对一时先保存1的一端后保存多的一端，这样不会多出额外的Update语句
	 */
	public void testManyToOne() {
		Customer customer=new Customer();
		customer.setAge("11");
		customer.setEmail("12233@163.com");
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		Order order=new Order();
		order.setOrderName("O_F_1");
		Order order2=new Order();
		order2.setOrderName("O_F_2");
		//设置关联关系
		order.setCustomer(customer);
		order2.setCustomer(customer);
		//执行保存
		manager.persist(customer);
		manager.persist(order);
		manager.persist(order2);
	}
	//不能直接删除1的一端，因为有外键约束
	//只能删除多的一方
	public void testManyToOnewRemove() {
//		Order order=manager.find(Order.class, 1);
//		manager.remove(order);
		Customer customer =manager.find(Customer.class, 1);
		manager.remove(customer);
	}
	/**
	 * 默认情况下使用左外连接来获取n的一方的对象和其关联的1的一方对象
	 * 可以使用@ManyToOne 的fetch属性来修改默认的关联属性的加载测略
	 */
	public void testManyToOneFind() {
		Order order=manager.find(Order.class, 1);
		System.out.println(order.getOrderName());
		System.out.println(order.getCustomer().getLastName());
	}
}
