package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.hotel.domain.Roomsort;
import com.leo.hotel.utils.PageBean;

/**
 * 房间分类
 * @author leoill
 *TODO
 *2018年11月30日
 */
public interface RoomSortService {
	/**
	 * 添加
	 * @param sort
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> add(Roomsort sort, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> update(Roomsort sort, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> deleteSort(String ids, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> getPageList(Integer page, Integer rows, PageBean pageBean);

	Map<String, Object> getSortListByAjax(HttpServletRequest request, HttpServletResponse response);

}
