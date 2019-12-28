package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.dto.UserQueryVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {
    List<User> query(UserQueryVO userQueryVO);

    int querySum(UserQueryVO userQueryVO);
}