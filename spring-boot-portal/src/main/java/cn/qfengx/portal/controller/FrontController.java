package cn.qfengx.portal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.qfengx.portal.service.CompanyService;
import cn.qfengx.portal.service.NewsService;
import cn.qfengx.portal.service.ProductService;
import cn.qfengx.portal.service.ProjectcaseService;

@RequestMapping("/front")
@RestController
public class FrontController {
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;
	
	@Autowired
	@Qualifier("ProjectcaseServiceImpl")
	private ProjectcaseService projectCaseService;
	@Autowired
	@Qualifier("NewsServiceImpl")
	private NewsService newsService;
	
	
	@RequestMapping("/p/info/{id}")
	@ResponseBody
	public Map<String, Object> pinfo(@PathVariable("id") Integer id, 
			HttpServletRequest req, HttpServletResponse resp) {
		return productService.info(id);
	}
	/**
	 * 前台获取
	 * @param id
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/case/info/{id}")
	@ResponseBody
	public Map<String, Object> cinfo(@PathVariable("id") Integer id,
			HttpServletRequest req,HttpServletResponse resp){
		return projectCaseService.info(id);
		
	}
	/**
	 * 前台获取
	 * @param id
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/news/info/{id}")
	@ResponseBody
	public Map<String, Object> newsinfo(@PathVariable("id") Integer id,
			HttpServletRequest req,HttpServletResponse resp){
		return newsService.info(id);	
	}
	
	
}
