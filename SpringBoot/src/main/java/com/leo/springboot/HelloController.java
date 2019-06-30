package com.leo.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot入门案例，基于springboot的springmvc配置
 * @author leoi555
 *
 */
@RestController
@RequestMapping("/springmvc")
public class HelloController {
	@RequestMapping("/hello")
	public  String sayHello(){
		return "helloSpringboot";
	}
}
