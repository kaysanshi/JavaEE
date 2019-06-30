package com.kaysanshi.institute.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaysanshi.institute.bean.Carousel;
import com.kaysanshi.institute.bean.Category;
import com.kaysanshi.institute.service.ContentCategoryService;
/**
 * 
 * @author kay三石
 *TODO
 *2019年4月5日-下午6:17:40
 */
@Controller
@RequestMapping("/content/cate")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService categoryService;
	
	@RequestMapping("/getallitem")
	@ResponseBody
	public Map<String, Object> getAllList(HttpServletRequest request,HttpServletResponse response){
		return categoryService.getAllList(response,request);
	}
	
	/**
	 * 获取分类列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> getlist(HttpServletRequest request,HttpServletResponse response){
		return categoryService.getlist(request,response);
	}
	/**
	 * 添加分类
	 * @param category
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addcate")
	@ResponseBody
	public Map<String, Object> addcate(Category category,HttpServletRequest request,HttpServletResponse response){
		if (category.getPid() !=null && category.getName() !=null) {
			return categoryService.addcate(category,request,response);
		}else {
			Map<String, Object> map=new HashMap<>();
			map.put("code", "1");
			map.put("msg", "请完善字段");
			map.put("data", null);
			return map;
		}
		
	}
	@RequestMapping("/upcate")
	@ResponseBody
	public Map<String, Object> upcate(Category category ,HttpServletResponse response, HttpServletRequest request){
		if (category.getPid() !=null && category.getName() !=null) {
			return categoryService.upcate(category,request,response);
		}else {
			Map<String, Object> map=new HashMap<>();
			map.put("code", "1");
			map.put("msg", "请完善字段");
			map.put("data", null);
			return map;
		}
	}
	
	@RequestMapping("/deletecate")
	@ResponseBody
	public Map<String, Object> deletecate(Category category ,HttpServletResponse response, HttpServletRequest request){
		if (category.getId()!=null) {
			return categoryService.deletecate(category,request,response);
		}else {
			Map<String, Object> map=new HashMap<>();
			map.put("code", "1");
			map.put("msg", "删除失败");
			map.put("data", null);
			return map;
		}
	}
	/**
	 *添加内容
	 * @param category
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addcontent")
	@ResponseBody
	public Map<String, Object> addcontent( Category category,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (category.getDescription()!=null) {
			return categoryService.addContent(category,request,response);
		}else {
			map.put("code", "1");
			map.put("msg","请添加内容");
			map.put("data", null);
			return map;
		}
		
	}
}
