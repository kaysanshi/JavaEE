package cn.qfengx.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qfengx.portal.bean.Company;
import cn.qfengx.portal.bean.CompanyQueryV;
import cn.qfengx.portal.mapper.CompanyMapper;
import cn.qfengx.portal.service.CompanyService;
/**
 * 
 * @author leoill
 *TODO
 *2019年2月21日
 */
@Transactional
@Service("CompanyserviceImpl")
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyMapper mapper;

	@Override
	public Map<String, Object> add(Company company) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (mapper.add(company)>0) {
			map.put("code", 0);
			map.put("msg", "添加成功");
			map.put("data", company);
		}else {
			map.put("code", 1);
			map.put("msg", "添加失败");
			map.put("data", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> list(CompanyQueryV nvo) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		nvo.setStart((nvo.getPage() - 1) * nvo.getLimit());
		List<Company> list = mapper.queryall(nvo);
		System.out.println(list);
		int sum =mapper.querySum(nvo);
		res.put("code", "0");
		res.put("msg", "获取成功");
		res.put("data", list);
		res.put("count", sum);
		return res;
	
	}

	@Override
	public Map<String, Object> update(Company company) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		if (mapper.update(company) > 0) {
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
			
			mapper.delete(ids);
			
			res.put("code", "0");
			res.put("msg", "删除成功");
			res.put("data", null);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
