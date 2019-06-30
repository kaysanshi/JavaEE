package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.domain.Room;
import com.leo.hotel.utils.PageBean;

/**
 * room
 * @author leoill
 *TODO
 *2018年11月30日
 */
public interface RoomService {
	/**
	 * 获取列表
	 * @param page
	 * @param rows
	 * @param pageBean
	 * @return
	 */
	Map<String, Object> getPageList(Integer page, Integer rows, PageBean pageBean);
	/**
	 * 添加
	 * @param room
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> add(Room room, MultipartFile file, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改
	 * @param room
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> update(Room room, MultipartFile file, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取房间列表
	 * @param merchantid 
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> getRoomListByAjax(String merchantid, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	Map<String, Object> delete(String ids);
	
}
