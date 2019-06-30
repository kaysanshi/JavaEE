package com.leo.course.scheduling.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.course.scheduling.domain.Department;
import com.leo.course.scheduling.mapper.DepartmentMapper;
import com.leo.course.scheduling.service.DepartmentService;
import com.leo.course.scheduling.utils.PageBean;
/**
 * 
 * @author kay三石
 *TODO
 *2019年3月5日-下午10:09:45
 */
@Service("DepartmentServiceImpl")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departMapper;
	@Autowired
	private PageBean pageBean;
	@Override
	public Map<String, Object> add(Department depart) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		depart.setAddtime(new Date());
		if (departMapper.add(depart)>0) {
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
		int totalCount=departMapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		//
		List<Department> listdata=departMapper.getPageQueryList(pageBean);
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
	public Map<String, Object> update(Department depart) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (departMapper.update(depart)>0) {
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
	public Map<String, Object> getBepartByname(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Department> listdata=departMapper.getDepartByname();
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
	public Map<String, Object> getBepartByno(Department department, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Department data=departMapper.getDepartByno(department);
		System.out.println("数据"+data);
		Map<String, Object> map=new HashMap<>();
		if (data!=null) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("data", data);
			return map;
		}else {
			map.put("msg", "获取失败");
			map.put("code", "0");
			map.put("data", null);
			return map;
		}
	}

	@Override
	public Map<String, Object> getBepartno(Department department, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Department> data=departMapper.getDepartNameByno(department);
		Department department2 = null;
		for(int i=0;i<data.size();i++) {
			 department2=data.get(0);
		}
		System.out.println(department2.toString());
		System.out.println("数据"+data);
		Map<String, Object> map=new HashMap<>();
		map.put("code", "0");
		map.put("msg", "获取成功");
		map.put("data", department2);
		return map;
	}

	@Override
	public Map<String, Object> getdepartBymajorno(Department department, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Department data=departMapper.getdepartBymajorno(department);
		System.out.println("数据"+data);
		Map<String, Object> map=new HashMap<>();
		if (data!=null) {
			map.put("code", "0");
			map.put("msg", "获取成功");
			map.put("data", data);
			return map;
		}else {
			map.put("msg", "获取失败");
			map.put("code", "0");
			map.put("data", null);
			return map;
		}
	}
}
