package cn.qfengx.portal.controller;

import java.util.Date;
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

import cn.qfengx.portal.bean.Carousel;
import cn.qfengx.portal.bean.CarouselQueryVo;
import cn.qfengx.portal.bean.Feedback;
import cn.qfengx.portal.bean.FeedbackQueryVo;
import cn.qfengx.portal.bean.Logo;
import cn.qfengx.portal.service.LogService;
import cn.qfengx.portal.service.SystemService;

/**
 * 系统相关接口
 * 		轮播图
 * 		Logo
 * 		留言
 * 		公司介绍
 * <p>Title: SystemController</p>
 * <p>Description: </p>
 * <p>Domain: qfengx.cn</p>
 * @author Qfeng
 * @date 2018年11月15日 下午9:11:06
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/sys")
public class SystemController {

	@Autowired
	@Qualifier("LogServiceImpl")
	private LogService logService;
	
	@Autowired
	@Qualifier("SystemServiceImpl")
	private SystemService systemService;
	
	@RequestMapping("/accesslog")
	@ResponseBody
	public Map<String, Object> accesslog() {
		Map<String, Object> map = new HashMap<>();
		return logService.recent(8);
	}
	
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
		
		if (carousel.getImg() == null || carousel.getImg().isEmpty()) {
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
				|| carousel.getImg() == null || carousel.getImg().isEmpty()) {
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
	public Map<String, Object> logo(Logo logo,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (logo.getLogo() == null || logo.getLogo().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		try {
			return systemService.logo(logo, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
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
	public Map<String, Object> logoquery(Logo logo,
			HttpServletRequest req, HttpServletResponse resp) {
		return systemService.logoquery();
	}
	
	
	
	
	
	//留言相关
	
	/**
	 * 获取留言列表
	 * 		page
	 * 		limit
	 * @param fdvo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/fd/list")
	@ResponseBody
	public Map<String, Object> fdlist(FeedbackQueryVo fdvo, 
			HttpServletRequest req, HttpServletResponse resp) {
		return systemService.fdlist(fdvo);
	}
	
	/**
	 * 添加留言
	 * @param feedback
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/fd/add")
	@ResponseBody
	public Map<String, Object> fdadd(Feedback feedback,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (feedback.getTitle() == null || feedback.getTitle().isEmpty()
				|| feedback.getContent() == null || feedback.getContent().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		feedback.setAddtime(new Date());
		return systemService.fdadd(feedback);
	}
	
	
	/**
	 * 删除留言
	 * @param ids
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/fd/delete")
	@ResponseBody
	public Map<String, Object> fddelete(@RequestParam(value = "ids[]") Integer[] ids,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (ids == null || ids.length == 0) {
			res.put("code", "1");
			res.put("msg", "请求数据不完整");
			res.put("data", null);
			return res;
		} 
		try {
			return systemService.fddelete(ids, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	
	//公司信息
	
	/**
	 * 获取公司信息
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/com/query")
	@ResponseBody
	public Map<String, Object> comquery(HttpServletRequest req, HttpServletResponse resp) {
		return systemService.comquery();
	}
}























