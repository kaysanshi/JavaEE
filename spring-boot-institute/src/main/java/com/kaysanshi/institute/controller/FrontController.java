package com.kaysanshi.institute.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaysanshi.institute.bean.Category;
import com.kaysanshi.institute.service.ContentCategoryService;



@RequestMapping("/front")
@RestController
public class FrontController {
	
	@Autowired
	private ContentCategoryService categoryService;
	
	@RequestMapping("/getitem")
	@ResponseBody
	public Map<String, Object> getItemById(Category category, HttpServletRequest request ,HttpServletResponse response){
		if (category.getId()!=null) {
			return categoryService.getItemById(category, response,request);
		}else {
			return null;
		}
	}
	
	
}
