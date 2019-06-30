package cn.qfengx.portal.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import cn.qfengx.portal.bean.Product;
import cn.qfengx.portal.bean.ProductQueryVo;
import cn.qfengx.portal.bean.Productcate;
import cn.qfengx.portal.bean.ProductcateQueryVo;

public interface ProductService {

	public Map<String, Object> list(ProductQueryVo qvp);

	public Map<String, Object> cquery();

	public Map<String, Object> add(Product product);

	@Deprecated
	public Map<String, Object> img(MultipartFile file, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> update(Product product, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> clist(ProductcateQueryVo pcvo);

	public Map<String, Object> cadd(Productcate productcate);

	public Map<String, Object> cupdate(Productcate productcate);

	public Map<String, Object> cdelete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp);

	public Map<String, Object> info(Integer id);
	
}
