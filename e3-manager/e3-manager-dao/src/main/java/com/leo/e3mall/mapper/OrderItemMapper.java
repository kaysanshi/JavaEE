package com.leo.e3mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.leo.e3mall.pojo.OrderItem;
import com.leo.e3mall.pojo.OrderItemExample;

public interface OrderItemMapper {
	 	int countByExample(OrderItemExample example);

	    int deleteByExample(OrderItemExample example);

	    int deleteByPrimaryKey(String id);

	    int insert(OrderItem record);

	    int insertSelective(OrderItem record);

	    List<OrderItem> selectByExample(OrderItemExample example);

	    OrderItem selectByPrimaryKey(String id);

	    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

	    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

	    int updateByPrimaryKeySelective(OrderItem record);

	    int updateByPrimaryKey(OrderItem record);
}
