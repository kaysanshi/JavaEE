package com.leo.e3mall.publish;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @author leoill
 *TODO
 *2019年1月8日
 */
public class TestPulish {
	
	@Test
	public void publishServer() throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContent-*.xml");
		while(true) {
			Thread.sleep(1000);
		}
//		Properties properties=new Properties();
//		System.out.println(TestPulish.class.getClassLoader());
//		System.out.println();
//		//下面的是直接放置在src目录下的文件的读取
//		System.out.println(TestPulish.class.getClassLoader().getResource("jdbc.properties").getFile());
//		//properties.load(getClass().getResourceAsStream("jdbc.properties"));
		
	}
}
