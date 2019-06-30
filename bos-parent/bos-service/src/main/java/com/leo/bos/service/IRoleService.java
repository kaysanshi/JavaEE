package com.leo.bos.service;

import java.util.List;

import com.leo.bos.domain.AuthRole;
import com.leo.bos.utils.PageBean;

/**
 * 
 * @author leoi555
 *
 */
public interface IRoleService {
	/**
	 * 添加的同时赋予权限
	 * @param model
	 * @param functionIds
	 */
	void add(AuthRole model, String functionIds);
	/**
	 * 分页
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);
	/**
	 * 加载role
	 * @return 
	 */
	List<AuthRole> listRole();

}
