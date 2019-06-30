package com.leo.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.springboot.domain.User;
import com.leo.springboot.service.UserService;

/**
 * 控制器
 * @author leoi555
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/getAll{name}")//带有参数的使用
	public List<User> getAll(@PathVariable("name")String name){
		List<User> list=userService.getAll(name);
		return list;	
	}
	//访问时就可以用/user/getAll来解决
}
