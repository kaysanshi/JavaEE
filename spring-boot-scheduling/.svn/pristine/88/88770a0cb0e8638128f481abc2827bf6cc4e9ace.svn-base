package com.leo.course.scheduling.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.course.scheduling.domain.Admin;
import com.leo.course.scheduling.service.UserService;

/**
 * 管理员管理
 * @author leoill
 *TODO
 *2019年2月27日
 */
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 * @param admin
	 * @param vercode
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(Admin admin,@RequestParam(value="vercode") String vercode,HttpServletRequest req,HttpServletResponse res){
		Map<String , Object> map=new HashMap<>();
		System.out.println(req.getSession().getAttribute("vercode"));
		System.out.println(vercode);
		if (vercode.equals(req.getSession().getAttribute("vercode"))) {
			return userService.login(admin,req,res);
		}else {
			map.put("code", "1");
			map.put("msg", "验证码错误");
			map.put("data", null);
			return map;
		}	
	}
	/**
	 * 用户信息接口
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("")
	@ResponseBody
	public Map<String, Object> user(HttpServletRequest req, HttpServletResponse resp) {
		return userService.user(req, resp);
	}
}
