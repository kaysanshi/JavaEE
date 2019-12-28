package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.dto.CategoryDTO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CategoryMapper extends Mapper<Category> {
    Category getList();

    List<Category> getlistBypid(String i);

    List<CategoryDTO> getCategorylistBypid(String s);

    List<Category> selectById(String id);
}