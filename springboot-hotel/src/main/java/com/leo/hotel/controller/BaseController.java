package com.leo.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leo.hotel.domain.Region;
import com.leo.hotel.domain.Starlevel;
import com.leo.hotel.domain.Type;
import com.leo.hotel.service.RegionService;
import com.leo.hotel.service.StarlevelService;
import com.leo.hotel.service.TypeService;
import com.leo.hotel.utils.JavaToJSon;
import com.leo.hotel.utils.PageBean;
/**
 * 地区查询
 * 类型查询
 * 星级查询
 * 房间分类
 * 
 * @author leoill
 *TODO
 *2018年11月29日
 */
@Controller
@RequestMapping("/base")
public class BaseController {
	@Autowired
	private RegionService regionService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private StarlevelService starService;
	@Autowired
	private PageBean pageBean;
	/**
	 * 地区的添加
	 * @param region
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addregion")
	@ResponseBody
	public Map<String, Object> addRegion(Region region,HttpServletRequest request,HttpServletResponse response){
		return regionService.addRegion(region,request,response);
		
	}
	/**
	 * 地区的修改
	 * @param region
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateregion")
	@ResponseBody
	public Map<String, Object> updateRegion(Region region,HttpServletRequest request,HttpServletResponse response){
		return regionService.update(region,request,response);
		
	}
	/**
	 * 地区获得分页列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/pagelist")
	@ResponseBody
	public void getRegionList(@RequestParam(name="page", required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		//设置当前页
		pageBean.setCurrentPage(page);
		//设置页大小
		pageBean.setPageSize(rows);
		System.out.println("当前页："+page);
		System.out.println("显示的行数："+rows);
		map=regionService.getList(page,rows,pageBean);
		System.out.println("列表zzz："+map.get("rows"));
		JavaToJSon.ResponseToJson(response, map);
	}
	/**
	 * 通过ajax来查询分区数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/regionbyajax")
	@ResponseBody
	public Map<String, Object> getRegionByAjaxQuery(HttpServletRequest request ,HttpServletResponse response){
		
		return regionService.getReionListByAjax(request,response);
	}
	
	/**
	 * 删除区域
	 * @param region
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteregion")
	@ResponseBody
	public Map<String, Object> deleteRegion(@RequestParam(value="ids") String ids,HttpServletRequest request,HttpServletResponse response){
		return regionService.deleteRegion(ids, request, response);
	}
	/**
	 * 类型添加
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addtype")
	@ResponseBody
	public Map<String, Object> addType(Type type,HttpServletRequest request ,HttpServletResponse response){
		return typeService.add(type,request,response);
	}
	/**
	 * 类型修改
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updatetype")
	@ResponseBody
	public Map<String, Object> updateType(Type type,HttpServletRequest request,HttpServletResponse response){
		return typeService.update(type,request,response);
		
	}
	/**
	 * 类型删除
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deletetype")
	@ResponseBody
	public Map<String, Object> deleteType(@RequestParam(value="ids") String ids,HttpServletRequest request,HttpServletResponse response){
		return typeService.deleteType(ids, request, response);
	}
	/**
	 * 类型分页
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listtype")
	@ResponseBody
	public void getTypeList(@RequestParam(name="page", required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		//设置当前页
		pageBean.setCurrentPage(page);
		//设置页大小
		pageBean.setPageSize(rows);
		System.out.println("当前页："+page);
		System.out.println("显示的行数："+rows);
		map=typeService.getPageList(page,rows,pageBean);
		JavaToJSon.ResponseToJson(response, map);
	}
	/**
	 * 获取类型列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/typebyajax")
	@ResponseBody
	public Map<String, Object> getTypeByAjaxQuery(HttpServletRequest request ,HttpServletResponse response){
		return typeService.getTypeListByAjax(request,response);
	}
	/**
	 * 星级管理
	 * @param star
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addstar")
	@ResponseBody
	public Map<String, Object> addStar(Starlevel star,HttpServletRequest request ,HttpServletResponse response){
		return starService.add(star,request,response);
	}
	/**
	 * 星级分页
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */
	@RequestMapping("/liststar")
	@ResponseBody
	public void getStarList(@RequestParam(name="page", required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		//设置当前页
		pageBean.setCurrentPage(page);
		//设置页大小
		pageBean.setPageSize(rows);
		System.out.println("当前页："+page);
		System.out.println("显示的行数："+rows);
		map=starService.getPageList(page,rows,pageBean);
		JavaToJSon.ResponseToJson(response, map);
	}
	/**
	 * 星级修改
	 * @param star
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updatestar")
	@ResponseBody
	public Map<String, Object> updateStar(Starlevel star,HttpServletRequest request ,HttpServletResponse response){
		return starService.update(star,request,response);
	}
	/**
	 * 删除
	 * @param ids
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deletestar")
	public Map<String, Object> deleteStar(@RequestParam(value="ids") String ids,HttpServletRequest request,HttpServletResponse response){
		return starService.deleteStar(ids, request, response);
	}
	/**
	 * 星级列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/starbyajax")
	@ResponseBody
	public Map<String, Object> getStarByAjaxQuery(HttpServletRequest request ,HttpServletResponse response){
		return starService.getStarListByAjax(request,response);
	}
}
