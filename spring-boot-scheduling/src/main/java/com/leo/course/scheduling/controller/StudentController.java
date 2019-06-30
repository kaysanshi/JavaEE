package com.leo.course.scheduling.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.course.scheduling.domain.Student;
import com.leo.course.scheduling.domain.Teacher;
import com.leo.course.scheduling.service.StudentService;

/**
 * 学生
 * @author kay三石
 *TODO
 *2019年3月11日-下午7:57:14
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	/**
	 * 添加
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Student student, HttpServletRequest request,HttpServletResponse response){
		Map<String , Object> map=new HashMap<>();
		if (student.getClassid()!=0) {
			return studentService.add(student,response,request);
		}else {
			map.put("code", "1");
			map.put("msg", "信息不完全");
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
		return studentService.list(page,limit,request,response);	
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
	public Map<String, Object> update(Student student,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (student.getClasses()==null) {
			map.put("code", "1");
			map.put("msg", "请填写完整的信息");
			map.put("data", null);
			return map;
		}else {
			return studentService.update(student);
		}
	} 

}
