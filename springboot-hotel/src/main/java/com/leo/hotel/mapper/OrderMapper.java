package com.leo.hotel.mapper;

import java.util.List;

import com.leo.hotel.domain.Order;
import com.leo.hotel.utils.PageBean;

/**
 * 
 * @author leoill
 *TODO
 *2018年12月2日
 */
public interface OrderMapper {
	/**
	 * 添加
	 * @param order
	 * @return
	 */
	int addOrder(Order order);
	/**
	 * 总记录
	 * @return
	 */
	int selectCount();
	/**
	 * 总的
	 * @param pageBean
	 * @return
	 */
	List<Order> getPageQueryList(PageBean pageBean);

}
