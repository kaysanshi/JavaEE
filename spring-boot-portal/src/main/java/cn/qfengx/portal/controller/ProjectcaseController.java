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

import cn.qfengx.portal.bean.Projectcase;
import cn.qfengx.portal.bean.ProjectcaseQueryVo;
import cn.qfengx.portal.service.ProjectcaseService;

/**
 * 工程案例接口
 * <p>Title: ProjectcaseController</p>
 * <p>Description: </p>
 * <p>Domain: qfengx.cn</p>
 * @author Qfeng
 * @date 2018年11月15日 下午9:08:27
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/case")
public class ProjectcaseController {
	
	@Autowired
	@Qualifier("ProjectcaseServiceImpl")
	private ProjectcaseService projectcaseService;
	
	
	/**
	 * 获取案例列表
	 * 		page
	 * 		limit
	 * @param pcsvo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(ProjectcaseQueryVo pcsvo, 
			HttpServletRequest req, HttpServletResponse resp) {
		return projectcaseService.list(pcsvo);
	}
	
	
	/**
	 * 添加案例
	 * @param projectcase
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Projectcase projectcase,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (projectcase.getTitle() == null || projectcase.getTitle().isEmpty()
				|| projectcase.getDetail() == null || projectcase.getDetail().isEmpty()
				|| projectcase.getImg() == null || projectcase.getImg().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		projectcase.setAddtime(new Date());
		projectcase.setClick(0);
		return projectcaseService.add(projectcase);
	}
	
	/**
	 * 删除案例
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
			return projectcaseService.delete(ids, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	/**
	 * 更新案例
	 * @param projectcase
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Projectcase projectcase,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (projectcase.getId() == null
				|| projectcase.getTitle() == null || projectcase.getTitle().isEmpty()
				|| projectcase.getDetail() == null || projectcase.getDetail().isEmpty()
				|| projectcase.getImg() == null || projectcase.getImg().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		try {
			return projectcaseService.update(projectcase, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
}




























