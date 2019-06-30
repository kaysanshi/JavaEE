package cn.qfengx.portal.controller;

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import cn.qfengx.portal.bean.Product;
import cn.qfengx.portal.bean.ProductQueryVo;
import cn.qfengx.portal.bean.Productcate;
import cn.qfengx.portal.bean.ProductcateQueryVo;
import cn.qfengx.portal.service.ProductService;

/**
 * 产品接口
 * <p>Title: ProductController</p>
 * <p>Description: </p>
 * <p>Domain: qfengx.cn</p>
 * @author Qfeng
 * @date 2018年11月15日 下午9:08:10
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/p")
public class ProductController {
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;
	
	/**
	 * 获取产品接口列表
	 * 		page 页数
	 * 		limit 每页显示数
	 * 		sort 日期排序方式
	 * 				0 降序
	 * 				1升序
	 * 		startDate
	 * 		endDate
	 * 			日期筛选
	 * 		key 关键词
	 * @param qvp
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(ProductQueryVo qvp, 
			HttpServletRequest req, HttpServletResponse resp) {
		return productService.list(qvp);
	}
	
	/**
	 * 添加产品
	 * @param product
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Product product,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (product.getName() == null || product.getName().isEmpty()
				|| product.getPcid() == null  
				|| product.getDetail() == null || product.getDetail().isEmpty()
				|| product.getImg() == null || product.getImg().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		product.setAddtime(new Date());
		product.setClick(0);
		return productService.add(product);
	}
	
	/**
	 * 删除产品
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
			return productService.delete(ids, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	/**
	 * 更新产品
	 * @param product
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Product product,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (product.getId() == null
				|| product.getName() == null || product.getName().isEmpty()
				|| product.getPcid() == null  
				|| product.getDetail() == null || product.getDetail().isEmpty()
				|| product.getImg() == null || product.getImg().isEmpty()) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		try {
			return productService.update(product, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
	/**
	 * 产品图片上传
	 * 		弃用，改用公共的 /common/img
	 * @param file
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/img")
	@ResponseBody
	@Deprecated
	public Map<String, Object> img(@RequestParam("file") MultipartFile file,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		try {
			res = productService.img(file, req, resp);
			return res;
		} catch (Exception e) {
			res.put("errno", "1");
			res.put("msg", e.getMessage());
			res.put("data", new ArrayList<>());
			return res;
		}
	}
	
	/**
	 * 获取所有产品分类
	 * @return
	 */
	@RequestMapping("/cquery")
	@ResponseBody
	public Map<String, Object> cquery() {
		Map<String, Object> res = new HashMap<>();
		return productService.cquery();
	}
	
	/**
	 * 产品分类列表
	 * 		page
	 * 		limit
	 * @param pcvo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/clist")
	@ResponseBody
	public Map<String, Object> clist(ProductcateQueryVo pcvo,
			HttpServletRequest req, HttpServletResponse resp) {
		return productService.clist(pcvo);
	}
	
	/**
	 * 添加产品分类
	 * @param productcate
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/cadd")
	@ResponseBody
	public Map<String, Object> cadd(Productcate productcate,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (productcate.getName() == null || productcate.getName().isEmpty()
				|| productcate.getPid() == null  ) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		return productService.cadd(productcate);
	}

	/**
	 * 更新产品分类
	 * @param productcate
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/cupdate")
	@ResponseBody
	public Map<String, Object> cupdate(Productcate productcate,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		
		if (productcate.getName() == null || productcate.getName().isEmpty()
				|| productcate.getPid() == null || productcate.getId() == null) {
			res.put("code", "1");
			res.put("msg", "信息不全");
			res.put("data", null);
			return res;
		}
		return productService.cupdate(productcate);
	}
	
	/**
	 * 删除产品分类
	 * @param ids
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/cdelete")
	@ResponseBody
	public Map<String, Object> cdelete(@RequestParam(value = "ids[]") Integer[] ids,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		if (ids == null || ids.length == 0) {
			res.put("code", "1");
			res.put("msg", "请求数据不完整");
			res.put("data", null);
			return res;
		} 
		try {
			return productService.cdelete(ids, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("code", "1");
			res.put("msg", e.getMessage());
			res.put("data", null);
			return res;
		}
	}
	
}





























