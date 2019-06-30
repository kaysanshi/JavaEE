package com.kaysanshi.institute.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaysanshi.institute.bean.Carousel;
import com.kaysanshi.institute.bean.CarouselQueryVo;
import com.kaysanshi.institute.mapper.CarouselMapper;
import com.kaysanshi.institute.service.SystemService;

@Transactional
@Service("SystemServiceImpl")
public class SystemServiceImpl implements SystemService {

	@Autowired
	private CarouselMapper carouselMapper;
	
	
	
	@Override
	public Map<String, Object> list(CarouselQueryVo cvo) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		cvo.setStart((cvo.getPage() - 1) * cvo.getLimit());
		List<Carousel> list = carouselMapper.query(cvo);
		int sum = carouselMapper.querySum(cvo);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	}

	@Override
	public Map<String, Object> add(Carousel carousel) {
		Map<String, Object> res = new HashMap<>();
		if (carouselMapper.add(carousel) > 0) {
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
	public Map<String, Object> delete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			
			carouselMapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Map<String, Object> update(Carousel carousel, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (carouselMapper.update(carousel) > 0) {
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
	public Map<String, Object> logo(Carousel logo, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (carouselMapper.updatelogo(logo) > 0) {
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
	public Map<String, Object> logoquery() {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", carouselMapper.querylogo());
		return res;
	}

	@Override
	public Map<String, Object> query() {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		List<Carousel> list = carouselMapper.queryAll();
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		return res;
	}

}
