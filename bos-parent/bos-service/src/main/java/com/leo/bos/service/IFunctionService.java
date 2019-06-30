package com.leo.bos.service;

import java.util.List;

import com.leo.bos.domain.AuthFunction;
import com.leo.bos.utils.PageBean;

/**
 * 
 * @author leoi555
 *
 */
public interface IFunctionService {

	/**
	 * 获得列表
	 * @return
	 */
	List<AuthFunction> getlist();
	/**
	 * 添加
	 * @param model
	 */
	void add(AuthFunction model);
	/**
	 * 分页
	 */
	void pageQuery(PageBean pageBean);
	/**
	 * 菜单加载
	 * @return
	 */
	List<AuthFunction> findMenu();
	
}
