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

import cn.qfengx.portal.bean.News;
import cn.qfengx.portal.bean.NewsQueryVo;
import cn.qfengx.portal.bean.Newscate;
import cn.qfengx.portal.bean.NewscateQueryVo;
import cn.qfengx.portal.service.NewsService;

/**
 * 新闻接口类
 * <p>Title: NewsController</p>
 * <p>Description: </p>
 * <p>Domain: qfengx.cn</p>
 * @author Qfeng
 * @date 2018年11月15日 下午9:01:38
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/n")
public class NewsController {
	
	@Autowired
	@Qualifier("NewsServiceImpl")
	private NewsService newsService;
	
	/**
	 * 获取新闻接口列表
	 * 		page 页数
	 * 		limit 每页显示数
	 * 		sort 日期排序方式
	 * 				0 降序
	 * 				1升序
	 * 		startDate
	 * 		endDate
	 * 			日期筛选
	 * 		key 关键词
	 * @param nvo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(NewsQueryVo nvo,
			HttpServletRequest req, HttpServletResponse resp) {
		return newsService.list(nvo);
	}
	
	/**
	 * 添加新闻
	 * @param news
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(News news,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (news.getTitle() == null || news.getTitle().isEmpty()
				|| news.getNcid() == null
				|| news.getDetail() == null || news.getDetail().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		news.setAddtime(new Date());
		news.setClick(0);
		return newsService.add(news);
	}
	
	/**
	 * 删除新闻
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
			return newsService.delete(ids, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	
	/**
	 * 更新新闻
	 * @param news
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(News news,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (news.getId() == null
				|| news.getNcid() == null  
				|| news.getTitle() == null || news.getTitle().isEmpty()
				|| news.getDetail() == null || news.getDetail().isEmpty()) {
			System.out.println(news.getTitle()+"lll:"+news.getDetail()+news.getId());
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		try {
			return newsService.update(news, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	/**
	 * 获取所有新闻类别
	 * @return
	 */
	@RequestMapping("/nquery")
	@ResponseBody
	public Map<String, Object> nquery() {
		Map<String, Object> res = new HashMap<>();
		return newsService.nquery();
	}
	
	/**
	 * 获取新闻类别列表
	 * 		page
	 * 		limit
	 * @param ncvo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/nlist")
	@ResponseBody
	public Map<String, Object> nlist(NewscateQueryVo ncvo,
			HttpServletRequest req, HttpServletResponse resp) {
		return newsService.nlist(ncvo);
	}
	
	/**
	 * 添加新闻类别
	 * @param newscate
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/nadd")
	@ResponseBody
	public Map<String, Object> nadd(Newscate newscate,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (newscate.getName() == null || newscate.getName().isEmpty()
				|| newscate.getPid() == null  ) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		return newsService.nadd(newscate);
	}
	
	
	/**
	 * 更新新闻类别
	 * @param newscate
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/nupdate")
	@ResponseBody
	public Map<String, Object> nupdate(Newscate newscate,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (newscate.getName() == null || newscate.getName().isEmpty()
				|| newscate.getPid() == null || newscate.getId() == null) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		return newsService.nupdate(newscate);
	}
	
	/**
	 * 删除新闻类别
	 * @param ids
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/ndelete")
	@ResponseBody
	public Map<String, Object> ndelete(@RequestParam(value = "ids[]") Integer[] ids,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (ids == null || ids.length == 0) {
			res.put("code", "1");
			res.put("msg", "请求数据不完整");
			res.put("data", null);
			return res;
		} 
		try {
			return newsService.ndelete(ids, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
}






















