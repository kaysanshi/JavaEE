package com.leo.hibernate;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leo.domain.User;
import com.leo.jdbc.UserDao;

/**
 * 通过交给Spring来实现
 * @author leoi555
 *
 */
public class HibernateSupportTest {
	private UserDao userDao;
	@Test
	public void delete() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		userDao=(UserDao) context.getBean("userDao");
		User user=new User();
		user.setId(1);
		userDao.deleteUser(user.getId());
		System.out.println("删除成功");
	}
}
