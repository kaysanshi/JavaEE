package com.leo.bos.service;

import org.springframework.transaction.annotation.Transactional;

import com.leo.bos.domain.User;
import com.leo.bos.utils.PageBean;

/**
 * 
 * @author leoi555
 *
 */
public interface IuserService {
	/**
	 * 登录
	 * @param model
	 * @return
	 */
	User login(User model);
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	//@Transactional
	void editPassword(String id, String password);
	/**
	 * 添加角色
	 * @param model
	 * @param roleIds
	 */
	void save(User model, String[] roleIds);
	/**
	 * 分页查询数据
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

}
