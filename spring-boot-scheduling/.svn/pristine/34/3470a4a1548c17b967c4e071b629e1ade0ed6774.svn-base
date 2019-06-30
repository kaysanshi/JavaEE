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
import com.leo.course.scheduling.domain.Teacher;
import com.leo.course.scheduling.service.TeacherService;

/**
 * 
 * @author kay三石
 *TODO
 *2019年3月9日-下午1:53:48
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 添加
	 * @param depart
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Teacher teacher,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (teacher.getDepartment()==null|| teacher.getIccode()==null) {
			map.put("code", "1");
			map.put("msg", "请填写完整的信息");
			map.put("data", null);
			return map;
		}else {
			return teacherService.add(teacher);
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
		return teacherService.list(page,limit,request,response);	
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
	public Map<String, Object> update(Teacher teacher,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (teacher.getDepartment()==null|| teacher.getIccode()==null) {
			map.put("code", "1");
			map.put("msg", "请填写完整的信息");
			map.put("data", null);
			return map;
		}else {
			return teacherService.update(teacher);
		}
	}
	/**
	 * 获取所有的教师
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getteacher")
	@ResponseBody
	public Map<String, Object> listteacher(HttpServletRequest request,HttpServletResponse response){
		return teacherService.listteacher(request,response);	
	}
	
	/**
	 * 通过id获取
	 * @param teacher
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getTeacherByid")
	@ResponseBody
	public Map<String, Object> getTeacherByid(Teacher teacher,HttpServletRequest request,HttpServletResponse response){
		return teacherService.getTeacherByid(teacher,request,response);	
	}

}
