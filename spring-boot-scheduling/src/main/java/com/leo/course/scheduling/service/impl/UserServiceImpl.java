package com.leo.course.scheduling.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.course.scheduling.domain.Admin;
import com.leo.course.scheduling.mapper.UserMapper;
import com.leo.course.scheduling.service.UserService;
import com.leo.course.scheduling.utils.MyUtils;
/**
 * 
 * @author leoill
 *TODO
 *
 */
@Service("UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper usermapper;

	@Override
	public Map<String, Object> login(Admin admin, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (admin.getUsername()==null&&admin.getPassword()==null) {
			map.put("code", "1");
			map.put("msg", "请输入用户名和密码");
			map.put("data", null);
			return map;
		}else {
			admin.setPassword(MyUtils.stringToMD5(admin.getPassword()));
			admin=usermapper.login(admin);
			if (admin==null) {
				map.put("code", "1");
				map.put("msg", "用户名或密码错误");
				map.put("data", null);
				return map;
			}else {
				req.getSession().setAttribute("admin", admin);
				map.put("code", "0");
				map.put("msg", "登录成功");
				map.put("data", admin);
				return map;
			}
			
		}
		
	}

	@Override
	public Map<String, Object> user(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		Admin user = (Admin) req.getSession().getAttribute("admin");
		if (user == null) {
			res.put("code", "1");
			res.put("msg", "没有用户信息");
			res.put("data", null);
		} else {
			Admin resuser = new Admin();
			resuser.setUsername(user.getUsername());
			res.put("code", "0");
			res.put("msg", "获取成功");
			res.put("data", resuser);
		}
		return res;
	}
}
