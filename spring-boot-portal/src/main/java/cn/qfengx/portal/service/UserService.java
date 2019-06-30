package cn.qfengx.portal.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qfengx.portal.bean.User;

public interface UserService {

	public Map<String, Object> login(User user, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> pwd(User user, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> exit(HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> user(HttpServletRequest req, HttpServletResponse resp);

}
