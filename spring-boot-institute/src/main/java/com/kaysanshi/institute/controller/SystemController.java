package com.kaysanshi.institute.controller;

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

import com.kaysanshi.institute.bean.Carousel;
import com.kaysanshi.institute.bean.CarouselQueryVo;
import com.kaysanshi.institute.service.SystemService;


/**
 * 系统相关接口
 * 		轮播图
 * 		Logo* 
 *
 */
@Controller
@RequestMapping("/sys")
public class SystemController {

	
	
	@Autowired
	@Qualifier("SystemServiceImpl")
	private SystemService systemService;
	
	
	
	/**
	 * 获取轮播图列表
	 * 		page
	 * 		limit
	 * @param cvo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(CarouselQueryVo cvo, 
			HttpServletRequest req, HttpServletResponse resp) {
		return systemService.list(cvo);
	}
	
	/**
	 * 获取所有轮播图
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest req, HttpServletResponse resp) {
		return systemService.query();
	}
	
	/**
	 * 添加轮播图
	 * @param carousel
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Carousel carousel,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (carousel.getImage() == null || carousel.getImage().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		return systemService.add(carousel);
	}
	
	/**
	 * 删除轮播图
	 * @param ids
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestParam(value = "ids[]") Integer[] ids,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (ids == null || ids.length == 0) {
			res.put("code", "1");
			res.put("msg", "请求数据不完整");
			res.put("data", null);
			return res;
		} 
		try {
			return systemService.delete(ids, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	/**
	 * 更新轮播图
	 * @param carousel
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Carousel carousel,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (carousel.getId() == null
				|| carousel.getImage() == null || carousel.getImage().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		try {
			return systemService.update(carousel, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	/**
	 * 更新logo
	 * @param logo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/logo/update")
	@ResponseBody
	public Map<String, Object> logo(Carousel logo,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		return systemService.logo(logo, req, resp);
		
	}
	
	/**
	 * 获取logo
	 * @param logo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/logo/query")
	@ResponseBody
	public Map<String, Object> logoquery(Carousel logo,
			HttpServletRequest req, HttpServletResponse resp) {
		return systemService.logoquery();
	}
	
}























