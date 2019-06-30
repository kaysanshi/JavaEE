package cn.qfengx.portal.controller;
/**
 * 公司管理
 * @author leoill
 *TODO
 *2019年2月21日
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.HttpResource;

import cn.qfengx.portal.bean.Company;
import cn.qfengx.portal.bean.CompanyQueryV;
import cn.qfengx.portal.bean.NewsQueryVo;
import cn.qfengx.portal.service.CompanyService;

@RequestMapping("/company")
@Controller
public class CompanyController {
	@Autowired
	private CompanyService comService;
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Company company,HttpServletRequest request,HttpServletResponse response){
		Map<String , Object> map=new HashMap<>();
		if (company.getName()==null|| company.getEmail()==null) {
			map.put("code", "1");
			map.put("msg", "信息不全");
			map.put("data", null);
		}
		return comService.add(company);
		
	}
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
	public Map<String, Object> list(CompanyQueryV nvo,
			HttpServletRequest req, HttpServletResponse resp) {
		return comService.list(nvo);
	}
	/**
	 * 修改
	 * @param company
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Company company,HttpServletRequest req,
			HttpServletResponse res){
		return comService.update(company);
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestParam(value="ids[]")Integer[] ids,HttpServletRequest req,HttpServletResponse res){
		Map<String, Object> map = new HashMap<>();
		if (ids == null || ids.length == 0) {
			map.put("code", "1");
			map.put("msg", "请求数据不完整");
			map.put("data", null);
			return map;
		} 
		try {
			return comService.delete(ids, req, res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", "1");
			map.put("msg", e.getMessage());
			map.put("data", null);
			return map;
		}
		
	}

}
