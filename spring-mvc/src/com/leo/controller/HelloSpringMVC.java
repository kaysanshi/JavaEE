package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器
 * @author leoi555
 *
 */
@Controller//把controller交给spring管理
@RequestMapping("/hello")//映射url：即指定请求的url地址
public class HelloSpringMVC {
	//设置请求的方法
	@RequestMapping(method=RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "SpringMVC");
		return "hello";
	}
}
