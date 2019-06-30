package com.kaysanshi.institute.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaysanshi.institute.bean.Carousel;
import com.kaysanshi.institute.bean.Category;

public interface ContentCategoryService {

	Map<String, Object> getlist(HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> addContent(Category category, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> addcate(Category category, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> upcate(Category category, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> deletecate(Category category, HttpServletRequest request, HttpServletResponse response);

	Map<String, Object> getAllList(HttpServletResponse response, HttpServletRequest request);

	Map<String, Object> getItemById(Category category, HttpServletResponse response, HttpServletRequest request);

}
