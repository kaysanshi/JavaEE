package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Banner;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BannerMapper extends Mapper<Banner> {
}