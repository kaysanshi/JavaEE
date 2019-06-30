package com.leo.course.scheduling.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.course.scheduling.domain.Admin;

/**
 * 
 * @author leoill
 *TODO
 *2019年2月27日
 */
public interface UserService {

	Map<String, Object> login(Admin admin, HttpServletRequest req, HttpServletResponse res);

	Map<String, Object> user(HttpServletRequest req, HttpServletResponse resp);

}
