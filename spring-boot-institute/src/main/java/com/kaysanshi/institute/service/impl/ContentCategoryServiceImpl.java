package com.kaysanshi.institute.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaysanshi.institute.bean.Carousel;
import com.kaysanshi.institute.bean.Category;
import com.kaysanshi.institute.mapper.ContentCategoryMapper;
import com.kaysanshi.institute.service.ContentCategoryService;

import ch.qos.logback.core.db.dialect.HSQLDBDialect;

@Service("ContentCategoryServiceImpl")
@Transactional
public class ContentCategoryServiceImpl implements ContentCategoryService{
	
	@Autowired
	private ContentCategoryMapper categoryMapper;

	@Override
	public Map<String, Object> getlist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		List<Category> list=categoryMapper.getlist();
		System.out.println(list);
		if (list!=null) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("data", list);
		}else {
			map.put("code", "1");
			map.put("msg", "获取失败");
			map.put("data", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> addContent(Category category, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (categoryMapper.addContent(category)>0) {
			map.put("code", "0");
			map.put("msg", "添加成功");
			map.put("data", null);
		}else {
			map.put("code", "1");
			map.put("msg", "添加失败");
			map.put("data", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> addcate(Category category, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		category.setAddtime(new Date());
//		category.setStatus(status);
		if (categoryMapper.addcate(category)>0) {
			map.put("code", "0");
			map.put("msg", "添加成功");
			map.put("data", null);
		}else {
			map.put("code", "1");
			map.put("msg", "添加失败");
			map.put("data", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> upcate(Category category, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		category.setAddtime(new Date());
		if (categoryMapper.upcate(category)>0) {
			map.put("code", "0");
			map.put("msg", "修改成功");
			map.put("data", null);
		}else {
			map.put("code", "1");
			map.put("msg", "修改失败");
			map.put("data", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> deletecate(Category category, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		category.setAddtime(new Date());
		if (categoryMapper.deletecate(category)>0) {
			map.put("code", "0");
			map.put("msg", "删除成功");
			map.put("data", null);
		}else {
			map.put("code", "1");
			map.put("msg", "删除失败");
			map.put("data", null);
		}
		return map;
	}
	/**
	 * 递归遍历查询出子类
	 * @param list
	 */
	private void subcate(List<Category> list) {
		if (list == null)
			return ;
		for (int i = 0; i < list.size(); i++) {
			List<Category> temp = categoryMapper.getlistBypid(list.get(i).getId());
			subcate(temp);
			list.get(i).setSublist(temp);
		}
	}
	
	@Override
	public Map<String, Object> getAllList(HttpServletResponse response, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		//先来查询出父级的节点
		List<Category> list = categoryMapper.getlistBypid(-1);
		subcate(list);
		if (list!=null) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("data", list);
		}else {
			map.put("code", "1");
			map.put("msg", "获取失败");
			map.put("data", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> getItemById(Category category, HttpServletResponse response,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		//先来查询出父级的节点
		Category list = categoryMapper.getItemByid(category.getId());
		System.out.println(list);
		if (list!=null) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("data", list);
		}else {
			map.put("code", "1");
			map.put("msg", "获取失败");
			map.put("data", null);
		}
		return map;
	}
}
