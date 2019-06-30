package com.leo.course.scheduling.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.course.scheduling.domain.Times;
import com.leo.course.scheduling.service.TimesService;
/**
 * 时间管理
 * @author kay三石
 *TODO
 *2019年3月5日-下午7:28:56
 */
@Controller
@RequestMapping("/times")
public class TimesController {
	
	@Autowired
	private TimesService timeService;
	/**
	 * 时间段的添加
	 * @param times
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Times times,HttpServletRequest request,HttpServletResponse response){
		times.setAddtime(new Date());
		return timeService.add(times,request,response);
	}
	/**
	 * 类表
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
		return timeService.list(page,limit,request,response);	
	}
}
