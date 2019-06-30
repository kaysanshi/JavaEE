package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.hotel.domain.Region;
import com.leo.hotel.utils.PageBean;

/**
 * 地区
 * @author leoill
 *TODO
 *2018年11月29日
 */
public interface RegionService {
	/**
	 * 获得地区列表
	 * @param page
	 * @param rows
	 * @param pageBean
	 * @return
	 */
	Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean);
	/**
	 * 修改
	 * @param region
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> update(Region region, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 添加
	 * @param region
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> addRegion(Region region, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> deleteRegion(String ids, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 通过ajax获取分区列表
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> getReionListByAjax(HttpServletRequest request, HttpServletResponse response);

}
