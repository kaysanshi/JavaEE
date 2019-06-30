package com.leo.service;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("基于cxf的开发被调用了。。。。。");
		return "hello"+name;
	}

}
