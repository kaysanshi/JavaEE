package com.leo.course.scheduling.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leo.course.scheduling.domain.Classroom;
import com.leo.course.scheduling.service.ClassRoomService;

/**
 * 教室管理
 * @author leoill
 *TODO
 *2019年3月3日
 */
@RequestMapping("/room")
@RestController
public class ClassRoomController {
	
	@Autowired
	private ClassRoomService roomService;
	/**
	 * 添加教室
	 * @param room
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Classroom room,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (room.getFloor()==null||room.getImage()==null||room.getCount()==null||room.getCode()==null) {
			map.put("code", "0");
			map.put("msg", "请完善教室信息");
			map.put("data", null);
			return map;
		}else {
			return roomService.add(room,request,response);
		}
	}
	/**
	 * 
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
		return roomService.list(page,limit,request,response);
		
	}
	/**
	 * 修改
	 * @param room
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Classroom room,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (room.getFloor()==null||room.getImage()==null||room.getCount()==null||room.getCode()==null) {
			map.put("code", "0");
			map.put("msg", "请完善教室信息");
			map.put("data", null);
			return map;
		}else {
			return roomService.update(room,request,response);
		}
	}

}
