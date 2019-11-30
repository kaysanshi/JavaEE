package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Admin;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AdminUserMapper extends Mapper <Admin> {

}