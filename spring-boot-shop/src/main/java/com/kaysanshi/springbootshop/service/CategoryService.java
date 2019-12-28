package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.dto.CategoryDTO;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
public interface CategoryService {
    List<Category> getCategoryList();

    Category getCategoryListById(Category category);

    List<Category> getCategoryListAll();

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Category category);

    List<CategoryDTO> getCategoryDTOList();

    List <Category> getCategoryDTOListBycid(String cid);

    List<Category> getListById(Category category1);
}
