package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Order;
import com.kaysanshi.springbootshop.dto.OrderQueryVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OrderMapper extends Mapper<Order> {
    List<Order> query(OrderQueryVO orderQueryVO);

    int querySum(OrderQueryVO orderQueryVO);
}