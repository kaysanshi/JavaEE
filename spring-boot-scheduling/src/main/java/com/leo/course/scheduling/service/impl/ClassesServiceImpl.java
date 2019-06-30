package com.leo.course.scheduling.service.impl;

import java.text.SimpleDateFormat;
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

import com.leo.course.scheduling.domain.Classes;
import com.leo.course.scheduling.domain.Teacher;
import com.leo.course.scheduling.mapper.ClassesMapper;
import com.leo.course.scheduling.service.ClassesService;
import com.leo.course.scheduling.utils.PageBean;
/**
 * 
 * @author kay三石
 *TODO
 *2019年3月7日-下午3:10:40
 */
@Service("ClassesServiceImpl")
@Transactional
public class ClassesServiceImpl implements ClassesService {
	
	@Autowired
	private ClassesMapper classesMapper;
	
	@Autowired
	private PageBean pageBean;
	
	@Override
	public Map<String, Object> add(Classes classes, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SimpleDateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=dFormat.format(new Date());
		Map<String, Object> map=new HashMap<>();
		classes.setAddtime(new Date());
		if (classesMapper.add(classes)>0) {
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
	public Map<String, Object> list(Integer page, Integer limit, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		//设置开始当前页
		pageBean.setCurrentPage((page-1)*limit);
		//设置每页页大小
		pageBean.setPageSize(limit);
		//查询总的记录数
		int totalCount=classesMapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		
		List<Classes> listdata=classesMapper.getPageQueryList(pageBean);
		pageBean.setRows(listdata);
		System.out.println("数据"+listdata);
		Map<String, Object> map=new HashMap<>();
		if (!listdata.isEmpty()) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("count", pageBean.getTotal());
			map.put("rows", pageBean.getRows());
			map.put("data", listdata);
			return map;
			}else {
				map.put("msg", "获取失败");
				map.put("code", "0");
				map.put("data", null);
			return map;
		}
	}

	@Override
	public Map<String, Object> getClasses(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Classes> listdata=classesMapper.getClassList();
		System.out.println("数据"+listdata);
		Map<String, Object> map=new HashMap<>();
		if (!listdata.isEmpty()) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("data", listdata);
			return map;
			}else {
				map.put("msg", "获取失败");
				map.put("code", "0");
				map.put("data", null);
			return map;
		}
	}

	@Override
	public Map<String, Object> getClassesById(Integer classid, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Classes listdata=classesMapper.getClassByid(classid);
		System.out.println("数据"+listdata);
		Map<String, Object> map=new HashMap<>();
		if (listdata!=null) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("data", listdata);
			return map;
			}else {
				map.put("msg", "获取失败");
				map.put("code", "0");
				map.put("data", null);
			return map;
		}
	}

	@Override
	public List<Classes> getListClassesName() {
		// TODO Auto-generated method stub
		List<Classes> listdata=classesMapper.getClassList();
		System.out.println("数据"+listdata);
		return listdata;
	}

	@Override
	public List<Classes> getListClassesById(List<String> list_majorno) {
		// TODO Auto-generated method stub
		List<Classes> list=new ArrayList<>();
		List<Classes> classesByListid=new ArrayList<>();
		for(int i=0;i<list_majorno.size();i++) {
			 classesByListid = classesMapper.getClassesByListid(list_majorno.get(i));
			list.addAll(classesByListid);
		}
		if (list.isEmpty()) {
			return null;
					
		}else {
			return list;
		}
	}
}
