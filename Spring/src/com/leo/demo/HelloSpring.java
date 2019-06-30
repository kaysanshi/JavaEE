package com.leo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author leoi555
 *
 */


public class HelloSpring {
	private  String  message;
	
	public HelloSpring() {
		System.out.println("无参构造方法");
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public static void main(String[] args) {
		//创建容器
		ApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		//获取容器中的对象
		HelloSpring obj=(HelloSpring) context.getBean("helloSpring");
		System.out.println(obj.getMessage());
	}
}
