package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.hotel.domain.Starlevel;
import com.leo.hotel.utils.PageBean;

/**
 * 星级
 * @author leoill
 *TODO
 *2018年11月29日
 */
public interface StarlevelService {
	/**
	 * 星级添加
	 * @param star
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> add(Starlevel star, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 星级分页
	 * @param page
	 * @param rows
	 * @param pageBean
	 * @return
	 */
	Map<String, Object> getPageList(Integer page, Integer rows, PageBean pageBean);
	/**
	 * 星级修改
	 * @param star
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> update(Starlevel star, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 星级删除
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> deleteStar(String ids, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 星级ajax
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> getStarListByAjax(HttpServletRequest request, HttpServletResponse response);

}
