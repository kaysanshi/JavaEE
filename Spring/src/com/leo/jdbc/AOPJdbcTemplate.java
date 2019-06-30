package com.leo.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leo.domain.User;

/**
 * 通过交给Spring来实现
 * @author leoi555
 *
 */
public class AOPJdbcTemplate {
		//先配置Datasource
		//JDBCTemplate需要接受连接池
	private UserDao userDao;
	
	public void add() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		userDao=(UserDao) context.getBean("userDao");
		User user=new User();
		user.setEmail("lkl@com");
		user.setName("123");
		user.setPassword("123");
		userDao.addUser(user);
		System.out.println("添加成功");
	}
	
	public void delete() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		userDao=(UserDao) context.getBean("userDao");
		User user=new User();
		user.setId(1);
		userDao.deleteUser(user.getId());
		System.out.println("删除成功");
	}
	
	public void update() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		userDao=(UserDao) context.getBean("userDao");
		User user=new User();
		user.setEmail("lkl@com");
		user.setName("123");
		user.setPassword("123");
		user.setId(3);
		userDao.updateUser(user);
		System.out.println("修改成功");
	}
	
	public User getUserbyId() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		userDao=(UserDao) context.getBean("userDao");
		System.out.println("获得成功");
		User user=new User();
		user.setId(4);
		User user2 =userDao.getUserbyId(user.getId());
		System.out.println("获得成功");
		System.out.println(user2.getId()+","+user2.getName()+","+user2.getPassword());
		return user2;
	}

	
	public List<User> getListUser() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		userDao=(UserDao) context.getBean("userDao");
		List<User> user2 =userDao.getAllUser();
		System.out.println("获得成功");
		return user2;
	}
}
