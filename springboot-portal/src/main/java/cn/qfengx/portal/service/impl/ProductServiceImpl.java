package cn.qfengx.portal.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.qfengx.portal.bean.Product;
import cn.qfengx.portal.bean.ProductQueryVo;
import cn.qfengx.portal.bean.Productcate;
import cn.qfengx.portal.bean.ProductcateQueryVo;
import cn.qfengx.portal.configuration.UploadConfig;
import cn.qfengx.portal.mapper.ProductMapper;
import cn.qfengx.portal.mapper.ProductcateMapper;
import cn.qfengx.portal.service.ProductService;

@Transactional
@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductcateMapper productcateMapper;
	
	@Autowired
	private UploadConfig uploadConfig;
	
	@Override
	public Map<String, Object> list(ProductQueryVo qvp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		qvp.setStart((qvp.getPage() - 1) * qvp.getLimit());
		List<Product> list = productMapper.query(qvp);
		int sum = productMapper.querySum(qvp);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	}

	@Override
	public Map<String, Object> add(Product product) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (productMapper.add(product) > 0) {
			res.put("code", "0");
			res.put("msg", "添加成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "添加失败");
			res.put("data", null);
		}
		return res;
	}
	
	@Override
	public Map<String, Object> update(Product product, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (productMapper.update(product) > 0) {
			res.put("code", "0");
			res.put("msg", "修改成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "修改失败");
			res.put("data", null);
		}
		return res;
	}
	
	@Override
	public Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			
			productMapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	@Deprecated
	public Map<String, Object> img(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			//保存文件名
			String savename = UUID.randomUUID().toString().replaceAll("-", "") + new Date().getTime();
			savename += file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			
			if (file.isEmpty()) {
				throw new RuntimeException("文件不能为空");
			}
			File dest = new File(uploadConfig.getPimgPath() + savename);
			
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			
			file.transferTo(dest);
			System.out.println("上传成功:" + uploadConfig.getPimgPath() + savename);
			res.put("errno", "0");
			List<String> list = new ArrayList<>();
			list.add("/pimg/" + savename);
			res.put("data", list);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	
	}
	
	
	@Override
	public Map<String, Object> cquery() {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		List<Productcate> list = productcateMapper.queryAll();
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", list.size());
		return res;
	}

	@Override
	public Map<String, Object> clist(ProductcateQueryVo pcvo) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		pcvo.setStart((pcvo.getPage() - 1) * pcvo.getLimit());
		List<Productcate> list = productcateMapper.query(pcvo);
		for (Productcate pc : list) {
			if (pc.getPid() != -1)
				pc.setPcname(productcateMapper.findById(pc.getPid()).getName());
		}
		int sum = productcateMapper.querySum(pcvo);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	}

	@Override
	public Map<String, Object> cadd(Productcate productcate) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (productcateMapper.add(productcate) > 0) {
			res.put("code", "0");
			res.put("msg", "添加成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "添加失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> cupdate(Productcate productcate) {
		// TODO Auto-generated method stub
		
		Map<String, Object> res = new HashMap<>();
		if (productcateMapper.update(productcate) > 0) {
			res.put("code", "0");
			res.put("msg", "修改成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "修改失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> cdelete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			
			productcateMapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	

	



}
