package com.leo.service;
/**
 * 	解析出来生成java代码，然后创建代理对象，通过代理对象实现远程调用
 * @author leoi555
 *
 */
public class Appclication {
	public static void main(String[] args) {
		HelloServiceService hsService=new HelloServiceService();
		//创建代理对象
		HelloService proxy=hsService.getHelloServicePort();
		String ret=proxy.sayHello("555");
		System.out.println(ret);
	}
	
	
}
