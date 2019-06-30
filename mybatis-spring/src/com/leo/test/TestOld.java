package com.leo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leo.domain.User;
import com.leo.mapper.UserMapper;
import com.leo.service.UserService;
import com.leo.service.impl.UserServiceImpl;

public class TestOld {



	/**
	 * 不用mapper代理的形式,直接使用原始的到开发
	 * @throws Exception
	 */
	@Test
	public void getlist() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

		UserService userService = context.getBean(UserService.class);
		userService.getListUser();
	}
}
