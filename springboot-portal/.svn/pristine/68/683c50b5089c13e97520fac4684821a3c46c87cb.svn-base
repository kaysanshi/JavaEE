package cn.qfengx.portal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qfengx.portal.bean.User;
import cn.qfengx.portal.service.UserService;

/**
 * 用户接口
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>Domain: qfengx.cn</p>
 * @author Qfeng
 * @date 2018年11月15日 下午9:13:19
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService userService; 
	
	/**
	 * 用户登录
	 * @param user
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(User user,
			HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println(user);
		Map<String, Object> res = new HashMap<>();
		if (user.getVercode() == null || user.getVercode().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "验证码不能为空");
			res.put("data", null);
			return res;
		}
		if (user.getUsername() == null || user.getUsername().isEmpty() ||
			user.getPassword() == null || user.getPassword().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "账号或密码不能为空");
			res.put("data", null);
			return res;
		}
		if (req.getSession().getAttribute("vercode") == null) {
			System.out.println("读取验证码：" + req.getSession().getAttribute("vercode"));
			res.put("code", "1");
			res.put("msg", "验证码异常");
			res.put("data", null);
			return res;
		} 
		if (!req.getSession().getAttribute("vercode").toString().equalsIgnoreCase(user.getVercode())) {
			res.put("code", "1");
			res.put("msg", "验证码错误");
			res.put("data", null);
			return res;
		}
		return userService.login(user, req, resp);
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
	
	
	
	/**
	 * 修改密码
	 * @param user
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/pwd")
	@ResponseBody
	public Map<String, Object> pwd(User user,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "原始密码不能为空");
			res.put("data", null);
		} else if (user.getNewpass() == null || user.getNewpass().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "新密码不能为空");
			res.put("data", null);
		} else {
			res = userService.pwd(user, req, resp);
		}
		return res;
	}
	
	
	/**
	 * 用户退出
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/exit")
	@ResponseBody
	public Map<String, Object> exit(HttpServletRequest req, HttpServletResponse resp) {
		return userService.exit(req, resp);
	}
}





























