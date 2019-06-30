package com.leo.course.scheduling.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.course.scheduling.domain.Subject;
import com.leo.course.scheduling.domain.Teacher;
import com.leo.course.scheduling.service.SubjectService;

/**
 * 学科管理
 * @author kay三石
 *TODO
 *2019年3月12日-下午1:39:38
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	/**
	 * 
	 * @param subject
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String , Object > add(Subject subject,HttpServletRequest request,HttpServletResponse response ){
		Map<String, Object> map=new HashMap<>();
		if (subject.getTeacherid()>0) {
			return subjectService.add(subject,request,response);
		}else {
			map.put("code", "1");
			map.put("msg", "信息不安全");
			map.put("data", null);
			return map;
		}
	}
	/**
	 * 获得list列表
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
		return subjectService.list(page,limit,request,response);	
	}
	/**
	 * 修改
	 * @param depart
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Subject subject,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (subject.getTeacherid()!=null) {
			map.put("code", "1");
			map.put("msg", "请填写完整的信息");
			map.put("data", null);
			return map;
		}else {
			return subjectService.update(subject);
		}
	} 
}
