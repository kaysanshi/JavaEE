package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.hotel.domain.Type;
import com.leo.hotel.utils.PageBean;

/**
 * 类型
 * @author leoill
 *TODO
 *2018年11月29日
 */
public interface TypeService {
	/**
	 * 类型添加
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> add(Type type, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 类型修改
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> update(Type type, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 分页列表
	 * @param page
	 * @param rows
	 * @param pageBean
	 * @return
	 */
	Map<String, Object> getPageList(Integer page, Integer rows, PageBean pageBean);
	/**
	 * 批量删除
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> deleteType(String ids, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 通过ajax查询
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> getTypeListByAjax(HttpServletRequest request, HttpServletResponse response);

}
