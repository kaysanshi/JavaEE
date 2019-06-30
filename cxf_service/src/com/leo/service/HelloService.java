package com.leo.service;

import javax.jws.WebService;

/**
 * 
 * @author leoi555
 *
 */
@WebService
public interface HelloService {
	public String sayHello(String name);
}
