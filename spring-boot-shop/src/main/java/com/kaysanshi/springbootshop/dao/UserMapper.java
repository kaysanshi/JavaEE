package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
}