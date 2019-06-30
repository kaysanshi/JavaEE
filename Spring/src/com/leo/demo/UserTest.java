package com.leo.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	@Test
	public void test() {
		ApplicationContext context= new ClassPathXmlApplicationContext("Beans.xml");
		User bean = (User)context.getBean("user");
		System.out.println(bean);
	}

	public void test1() {
		ApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		User bean=(User)context.getBean("user2");
		System.out.println(bean);
	}
	/**
	 * 多例
	 */
	@Test
	public void test2() {
		ApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		User bean=(User)context.getBean("user1");
		User bean1=(User)context.getBean("user1");
		User bean2=(User)context.getBean("user1");
		User bean3=(User)context.getBean("user1");
		System.out.println(bean1==bean2);
	}
	/**
	 *声明周期
	 */
	@Test
	public void test3() {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		User bean=(User)context.getBean("user1");
		System.out.println(bean);
		context.close();
	}
	/**
	 *引用类型注入
	 */
	@Test
	public void test4() {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		User bean=(User)context.getBean("user3");
		System.out.println(bean.getCar().getName());
		context.close();
	}
	/**
	 * 构造函数注入指定走哪一个构造函数 配置走name ,car 
	 * <bean name="user4" class="com.leo.demo.User">
   		<constructor-arg name="name" index="0" type="String" value="黑市"></constructor-arg>
   		<constructor-arg name="car" index="1" ref="car"></constructor-arg>
   		</bean>
   		
	 */
	@Test
	public void test5() {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		User bean=(User)context.getBean("user4");
		System.out.println(bean.getCar().getName());
		context.close();
	}
	/**
	 * 构造函数注入指定走哪一个构造函数配置走car name
	 * <bean name="user5" class="com.leo.demo.User">
   		<constructor-arg name="name" index="1" type="String" value="黑市"></constructor-arg>
   		<constructor-arg name="car" index="0" ref="car"></constructor-arg>
   		</bean>
	 */
	@Test
	public void test6() {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		User bean=(User)context.getBean("user5");
		System.out.println(bean.getCar().getName());
		context.close();
	}
	/**
	 * 注入集合类型
	 */
	@Test
	public void test7() {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		CollectionBean bean=(CollectionBean)context.getBean("javaCollection");
		System.out.println(bean.getAddressList());
		System.out.println(bean.getAddressMap().get("user"));
		System.out.println(bean.getAddressSet());
		System.out.println(bean.getAddressProp());
		context.close();
	}

}
