package com.leo.mapper;
/**
 *mapper代理
 * @author leoi555
 *
 */

import java.util.List;

import com.leo.domain.Orders;
import com.leo.domain.User;


public interface OrderMapper {
	//查询订单order的所有的数据
	public List<Orders> listOrder();
	//返回值为resultMap类型的
	public List<Orders> listOrderByMap();
	//一对一关联查询
	public List<Orders> selectOrders();
	//一对多关联订单
	
	public List<User> selectUsers();
	
	
		
}
