package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Orderitem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderitemMapper extends Mapper<Orderitem> {
}