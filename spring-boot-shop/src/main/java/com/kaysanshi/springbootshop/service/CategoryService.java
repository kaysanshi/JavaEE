package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.Category;

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
}
