package com.leo.hibernate;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.leo.domain.User;

/**
 * 用外部的配置文件
 * 和用Spring整合的方式来设置这些
 * @author leoi555
 *
 */
public class HibernateTest {
	
	
	
	
	public void function() {
		Configuration con=new Configuration();
		//2.读取配置文件==>空参加载时加载的src下的hibernate.cfg.xml文件
		con.configure();
		//3.读取映射文件基本上不用，读取的为.property,主配置文件引入后就不需要用这个方法了
		//con.addResource(resourceName);con.addClass(persistentClass);
		//4.构建SessionFactory对象、用于获取session对象操作数据库的核心对象
		SessionFactory sFactory=con.buildSessionFactory();
		Session session= sFactory.openSession();
		Transaction transaction=session.beginTransaction();
		///
		User user=new User();
		user.setEmail("1233@qq.com");
		user.setName("jodd");
		user.setPassword("123");
		session.save(user);
		transaction.commit();
		session.close();
	}
	public static void main(String[] args) { 
		HibernateTest test=new HibernateTest();
		test.function();
		System.out.println(111);
	}
}
