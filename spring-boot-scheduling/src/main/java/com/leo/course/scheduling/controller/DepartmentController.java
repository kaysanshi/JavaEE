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

import com.leo.course.scheduling.domain.Department;
import com.leo.course.scheduling.service.DepartmentService;

/**
 * 
 * @author kay三石
 *TODO
 *2019年3月5日-下午10:03:21
 */
@Controller
@RequestMapping("depart")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departService;
	/**
	 * 添加
	 * @param depart
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Department depart,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (depart.getDepname()==null||depart.getDepno()==null||
				depart.getMajorno()==null||depart.getMajorname()==null) {
			map.put("code", "1");
			map.put("msg", "请填写完整的信息");
			map.put("data", null);
			return map;
		}else {
			return departService.add(depart);
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
		return departService.list(page,limit,request,response);	
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
	public Map<String, Object> update(Department depart,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (depart.getDepname()==null||depart.getDepno()==null||
				depart.getMajorno()==null||depart.getMajorname()==null) {
			map.put("code", "1");
			map.put("msg", "请填写完整的信息");
			map.put("data", null);
			return map;
		}else {
			return departService.update(depart);
		}
	}
	/**
	 * 获取院系名称
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getDepart")
	@ResponseBody
	public Map<String, Object> getDepartByname(HttpServletRequest request,HttpServletResponse response){
		return departService.getBepartByname(request,response);
		
	}
	/**
	 * 通过编号获取名称
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getdepartByno")
	@ResponseBody
	public Map<String, Object> getDepartByno(Department department,HttpServletRequest request,HttpServletResponse response){
		return departService.getBepartByno(department,request,response);
		
	}
	/**
	 * 通过获取院系的名称
	 * @param department
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getdepartBydepartmentno")
	@ResponseBody
	public Map<String, Object> getDepartno(Department department,HttpServletRequest request,HttpServletResponse response){
		return departService.getBepartno(department,request,response);
		
	}
	@RequestMapping("/getdepartBymajorno")
	@ResponseBody
	public Map<String, Object> getdepartBymajorno(Department department,HttpServletRequest request,HttpServletResponse response){
		return departService.getdepartBymajorno(department,request,response);
		
	}
}
