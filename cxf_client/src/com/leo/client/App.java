package com.leo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 * @author leoi555
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("cxf.xml");
		HelloService service=(HelloService) context.getBean("myclient");
		String ret=service.sayHello("cxf:::");
		System.out.println(ret);
	}
}
