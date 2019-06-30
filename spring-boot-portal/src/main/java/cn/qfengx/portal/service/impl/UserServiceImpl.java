package cn.qfengx.portal.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qfengx.portal.bean.User;
import cn.qfengx.portal.mapper.UserMapper;
import cn.qfengx.portal.service.UserService;
import cn.qfengx.portal.util.MyUtils;

@Transactional
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Map<String, Object> login(User user, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		
		user.setPassword(MyUtils.stringToMD5(user.getPassword()));
		user = userMapper.login(user);
		
		String ip = MyUtils.getIP(req);
		
		if (user == null) {
			res.put("code", "1");
			res.put("msg", "账号或密码错误");
			res.put("data", null);
		} else {
			req.getSession().setAttribute("user", user);
			User resuser = new User();
			resuser.setNick(user.getNick());
			resuser.setIp(user.getIp());
			resuser.setTime(user.getTime());
			
			//更新登录信息
			
			User upuser = new User();
			upuser.setId(user.getId());
			upuser.setIp(ip);
			upuser.setTime(new Date());
			
			userMapper.updateLogin(upuser);
			
			res.put("code", "0");
			res.put("msg", "登录成功");
			res.put("data", resuser);
		}
		return res;
	}

	@Override
	public Map<String, Object> user(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			res.put("code", "1");
			res.put("msg", "没有用户信息");
			res.put("data", null);
		} else {
			User resuser = new User();
			resuser.setNick(user.getNick());
			resuser.setUsername(user.getUsername());
			resuser.setTime(user.getTime());
			resuser.setIp(user.getIp());
			res.put("code", "0");
			res.put("msg", "获取成功");
			res.put("data", resuser);
		}
		return res;
	}
	
	@Override
	public Map<String, Object> pwd(User user, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		User requser = (User) req.getSession().getAttribute("user");
		
		if (!requser.getPassword().equals(MyUtils.stringToMD5(user.getPassword()))) {
			res.put("code", "1");
			res.put("msg", "原密码错误");
			res.put("data", null);
			return res;
		}
		if (requser.getPassword().equals(MyUtils.stringToMD5(user.getNewpass()))) {
			res.put("code", "1");
			res.put("msg", "新密码不能和原密码一样");
			res.put("data", null);
			return res;
		}
		requser.setPassword(MyUtils.stringToMD5(user.getNewpass()));
		if (userMapper.updatepwd(requser) > 0) {
			res.put("code", "0");
			res.put("msg", "修改成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "修改失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> exit(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		req.getSession().removeAttribute("user");
		res.put("code", "0");
		res.put("msg", "退出成功");
		res.put("data", null);
		System.out.println("exit");
		return res;
	}
	
}
