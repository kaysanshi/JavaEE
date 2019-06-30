package com.leo.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;


@WebService
public class HelloService {
	public String sayHello(String  name) {
		System.out.println("你的服务被调用该");
		return "hello"+name;
	}
	//http://10.33.8.112:8080/hello?wsdl
	//访问服务说明书形式
	///http://10.33.8.112:8080/hello?xsd=1查看其中的方法和其中的参数
	public static void main(String[] args) {
		String address="http://10.33.8.112:8080/hello";
		Object helloService = new HelloService();
		Endpoint.publish(address, helloService);
	}
}
