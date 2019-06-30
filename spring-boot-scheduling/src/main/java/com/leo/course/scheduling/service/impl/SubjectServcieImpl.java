package com.leo.course.scheduling.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.course.scheduling.domain.Subject;
import com.leo.course.scheduling.domain.Teacher;
import com.leo.course.scheduling.mapper.SubjectMapper;
import com.leo.course.scheduling.service.SubjectService;
import com.leo.course.scheduling.utils.PageBean;
/**
 * 
 * @author kay三石
 *TODO
 *2019年3月12日-下午1:45:12
 */
@Service("SubjectServcieImpl")
@Transactional
public class SubjectServcieImpl implements SubjectService {
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Autowired
	private PageBean pageBean;
	
	@Override
	public Map<String, Object> add(Subject subject, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (subjectMapper.add(subject)>0) {
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
		pageBean.setCurrentPage((page-1)*limit);
		//设置每页页大小
		pageBean.setPageSize(limit);
		//查询总的记录数
		int totalCount=subjectMapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		//
		List<Subject> listdata=subjectMapper.getPageQueryList(pageBean);
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
	public Map<String, Object> update(Subject subject) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (subjectMapper.update(subject)>0) {
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
	public List<Subject> getListSubjectName() {
		// TODO Auto-generated method stub
		List<Subject> listdata=subjectMapper.getListSubjectName();
		if (!listdata.isEmpty()) {
			return listdata;
		}else {
			return null;
		}
		
	}

}
