package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.domain.User;
import com.leo.hotel.utils.PageBean;

/**
 * 
 * @author leoi555
 *
 */
public interface UserService{
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	Map<String, Object> addUser(User user);
	/**
	 * 
	 * @param user
	 * @return 
	 */
	Map<String, Object> checkUser(User user);
	/**
	 * 获得列表
	 * @param rows 
	 * @param page 
	 * @param pageBean
	 * @return 
	 */
	Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean);
	/**
	 * 更新并且上传
	 * @param user
	 * @param file
	 * @param response
	 * @param req
	 * @return
	 */
	Map<String, Object> updateUser(User user, MultipartFile file, HttpServletResponse response, HttpServletRequest req);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	Map<String, Object> delete(String ids);

}
