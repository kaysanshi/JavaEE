package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.hotel.domain.Order;
import com.leo.hotel.utils.PageBean;

/**
 * 订单
 * @author leoill
 *TODO
 *2018年12月2日
 */
public interface OrderService {
	/**
	 * 添加订单
	 * @param order
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> addOrder(Order order, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 订单列表
	 * @param page
	 * @param rows
	 * @param pageBean
	 * @return
	 */
	Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean);

}
