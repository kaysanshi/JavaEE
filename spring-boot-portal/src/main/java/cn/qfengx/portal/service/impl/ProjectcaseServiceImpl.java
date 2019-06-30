package cn.qfengx.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qfengx.portal.bean.Product;
import cn.qfengx.portal.bean.Projectcase;
import cn.qfengx.portal.bean.ProjectcaseQueryVo;
import cn.qfengx.portal.mapper.ProjectcaseMapper;
import cn.qfengx.portal.service.ProjectcaseService;

@Transactional
@Service("ProjectcaseServiceImpl")
public class ProjectcaseServiceImpl implements ProjectcaseService {

	@Autowired
	private ProjectcaseMapper projectcaseMapper;
	
	@Override
	public Map<String, Object> list(ProjectcaseQueryVo pcsvo) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		pcsvo.setStart((pcsvo.getPage() - 1) * pcsvo.getLimit());
		List<Product> list = projectcaseMapper.query(pcsvo);
		int sum = projectcaseMapper.querySum(pcsvo);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	}

	@Override
	public Map<String, Object> add(Projectcase projectcase) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (projectcaseMapper.add(projectcase) > 0) {
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
			
			projectcaseMapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Map<String, Object> update(Projectcase projectcase, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (projectcaseMapper.update(projectcase) > 0) {
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
	public Map<String, Object> info(Integer id) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			Projectcase project=projectcaseMapper.queryById(id);
			res.put("code", "0");
			res.put("msg", "获取成功");
			res.put("data", project);
		}catch (Exception e) {
			// TODO: handle exception
			res.put("code", "1");
			res.put("msg", "获取失败");
			res.put("data", null);
		}
		return res;
	}

}
