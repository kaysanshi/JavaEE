package com.leo.test;

import org.apache.catalina.mapper.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leo.domain.User;
import com.leo.mapper.UserMapper;

/**
 * 测试类
 * @author leoi555
 *
 */
public class UserMapperDemoTest {
	
	/**
	 * 测试动态代理mapper
	 */
	@Test
	public void test() {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper bean = context.getBean(UserMapper.class);
		User user=bean.getUserById(10);
		System.out.println(user);
	}
}
