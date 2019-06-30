package com.leo.springboot.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.leo.Application;
import com.leo.springboot.domain.User;
import com.leo.springboot.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)//属性：用于指定引导类
public class SpringBootJunitTest {
	@Autowired
	private UserService userService;
	@Test
	public void testFindAll() {
		List<User> list=userService.getAll();
		System.out.println(list);
	}
	
	//读取配置文件
	@Resource
	private Environment environment;
	
	@Test
	public void testReadSpringBootConfig() {
		System.out.println(environment.getProperty("spring.datasource.url"));
	}
}
