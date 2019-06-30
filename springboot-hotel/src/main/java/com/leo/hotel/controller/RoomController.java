package com.leo.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.domain.Room;
import com.leo.hotel.domain.Roomsort;
import com.leo.hotel.service.RoomService;
import com.leo.hotel.service.RoomSortService;
import com.leo.hotel.utils.JavaToJSon;
import com.leo.hotel.utils.PageBean;
/**
 * room
 * 添加房间分类
 * 房间管理
 * @author leoill
 *TODO
 *2018年11月30日
 */
@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	@Qualifier("RoomServieImpl")
	private RoomService roomService;
	@Autowired
	private PageBean pageBean;
	@Autowired
	@Qualifier("RoomSortServiceImpl")
	private RoomSortService sortService;
	/**
	 * 
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestParam(value="ids") String ids, HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
			map=roomService.delete(ids);
		return map;
		
	}
	/**
	 * 获得房屋
	 * @param merchantid
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/roombyajax")
	@ResponseBody
	public Map<String, Object> getRoomByAjaxQuery(String merchantid,HttpServletRequest request ,HttpServletResponse response){
		return roomService.getRoomListByAjax(merchantid,request,response);
	}
	/**
	 * 修改
	 * @param room
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateroom")
	@ResponseBody
	public Map<String, Object> updateRoom(Room room,@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		return roomService.update(room,file,request,response);
		
	}
	/**
	 * 添加
	 * @param room
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addroom")
	@ResponseBody
	public Map<String, Object> addRoom(Room room,@RequestParam("file")MultipartFile file, HttpServletRequest request ,HttpServletResponse response){
		return roomService.add(room,file,request,response);
	}
	/**
	 * 房屋列表
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listroom")
	@ResponseBody
	public void getRoomList(@RequestParam(name="page",
	required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		//设置当前页
		pageBean.setCurrentPage(page);
		//设置页大小
		pageBean.setPageSize(rows);
		System.out.println("当前页："+page);
		System.out.println("显示的行数："+rows);
		map=roomService.getPageList(page,rows,pageBean);
		JavaToJSon.ResponseToJson(response, map);
	}
	
	/**
	 * 房屋类型添加
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addsort")
	@ResponseBody
	public Map<String, Object> addSort(Roomsort sort,HttpServletRequest request ,HttpServletResponse response){
		return sortService.add(sort,request,response);
	}
	/**
	 * 房屋类型修改
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updatesort")
	@ResponseBody
	public Map<String, Object> updateSort(Roomsort sort,HttpServletRequest request,HttpServletResponse response){
		return sortService.update(sort,request,response);
		
	}
	/**
	 * 房屋类型删除
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deletesort")
	@ResponseBody
	public Map<String, Object> deleteSort(@RequestParam(value="ids") String ids,HttpServletRequest request,HttpServletResponse response){
		return sortService.deleteSort(ids, request, response);
	}
	/**
	 * 房屋类型分页
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listsort")
	@ResponseBody
	public void getSortList(@RequestParam(name="page", required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		//设置当前页
		pageBean.setCurrentPage(page);
		//设置页大小
		pageBean.setPageSize(rows);
		System.out.println("当前页："+page);
		System.out.println("显示的行数："+rows);
		map=sortService.getPageList(page,rows,pageBean);
		JavaToJSon.ResponseToJson(response, map);
	}
	/**
	 * 获取房屋类型列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/sortbyajax")
	@ResponseBody
	public Map<String, Object> getSortByAjaxQuery(HttpServletRequest request ,HttpServletResponse response){
		return sortService.getSortListByAjax(request,response);
	}
	
	
}
