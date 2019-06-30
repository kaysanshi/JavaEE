package cn.qfengx.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qfengx.portal.bean.Carousel;
import cn.qfengx.portal.bean.CarouselQueryVo;
import cn.qfengx.portal.bean.Company;
import cn.qfengx.portal.bean.Feedback;
import cn.qfengx.portal.bean.FeedbackQueryVo;
import cn.qfengx.portal.bean.Logo;
import cn.qfengx.portal.mapper.CarouselMapper;
import cn.qfengx.portal.mapper.CompanyMapper;
import cn.qfengx.portal.mapper.FeedbackMapper;
import cn.qfengx.portal.mapper.LogoMapper;
import cn.qfengx.portal.service.SystemService;

@Transactional
@Service("SystemServiceImpl")
public class SystemServiceImpl implements SystemService {

	@Autowired
	private CarouselMapper carouselMapper;
	
	@Autowired	
	private LogoMapper logoMapper;
	
	@Autowired
	private FeedbackMapper feedbackMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
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
	public Map<String, Object> logo(Logo logo, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (logoMapper.update(logo) > 0) {
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
		res.put("data", logoMapper.query());
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

	@Override
	public Map<String, Object> fdadd(Feedback feedback) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (feedbackMapper.add(feedback) > 0) {
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
	public Map<String, Object> fddelete(Integer[] ids, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			
			feedbackMapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Map<String, Object> fdlist(FeedbackQueryVo fdvo) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		fdvo.setStart((fdvo.getPage() - 1) * fdvo.getLimit());
		List<Feedback> list = feedbackMapper.query(fdvo);
		int sum = feedbackMapper.querySum(fdvo);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	}

	@Override
	public Map<String, Object> comquery() {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		res.put("code", "0");
		res.put("msg", "获取成功");
		Company company = companyMapper.query();
		res.put("data", company);
		return res;
	}

}
