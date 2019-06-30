package com.leo.course.scheduling.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.course.scheduling.domain.Classes;
import com.leo.course.scheduling.service.ClassesService;

/**
 * 班级管理
 * @author kay三石
 *TODO
 *2019年3月7日-下午2:59:12
 */
@Controller
@RequestMapping("classes")
public class ClassessController {
	
	@Autowired
	private ClassesService classesService;
	/**
	 * 添加
	 * @param classes
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Classes classes,HttpServletRequest request, HttpServletResponse response){
		System.out.println(classes.getDepartment());
		Map<String, Object> map=new HashMap<>();
		if (classes.getDepartment()!=null &&classes.getSpecialty()!=null) {
			return classesService.add(classes,request,response);
		}else {
			map.put("code", "1");
			map.put("msg", "请完善信息");
			map.put("data", null);
			return map;
		}
			
	}
	/**
	 * 获取列表
	 * @param page
	 * @param limit
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="page") Integer page,
			@RequestParam(value="limit" )Integer limit,
			HttpServletRequest request,HttpServletResponse response){
		return classesService.list(page,limit,request,response);
		
	}
	/**
	 * 获取所有的选项
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getclass")
	@ResponseBody
	public Map<String, Object> getClass(HttpServletRequest request,HttpServletResponse response) {
		return classesService.getClasses(request,response);
	}
	
	/**
	 * 通过id来获取
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getclassByid")
	@ResponseBody
	public Map<String, Object> getClassById(@RequestParam(value="classid") Integer classid,HttpServletRequest request,HttpServletResponse response) {
		return classesService.getClassesById(classid,request,response);
	}
}
