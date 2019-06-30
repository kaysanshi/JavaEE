package com.kaysanshi.institute.mapper;

import java.util.List;

import com.kaysanshi.institute.bean.Category;

public interface ContentCategoryMapper {

	List<Category> getlist();

	int addContent(Category category);

	int addcate(Category category);

	int upcate(Category category);

	int deletecate(Category category);

	List<Category> getlistBypid(Integer pid);

	List<Category> getsublist(List<Integer> list2);

	Category getItemByid(Integer id);

}
