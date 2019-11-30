package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderMapper extends Mapper<Order> {
}