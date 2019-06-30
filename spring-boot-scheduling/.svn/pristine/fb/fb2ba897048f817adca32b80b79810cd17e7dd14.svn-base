package com.leo.course.scheduling.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leo.course.scheduling.domain.Classroom;
import com.leo.course.scheduling.mapper.ClassRoomMapper;
import com.leo.course.scheduling.service.ClassRoomService;
import com.leo.course.scheduling.utils.PageBean;
/**
 * 教室
 * @author kay三石
 *TODO 基本的增删改
 *2019年3月3日-上午11:57:34
 */
@Service("ClassRoomServiceImpl")
@Transactional
public class ClassRoomServiceImpl implements ClassRoomService {
	
	
	@Autowired
	private ClassRoomMapper mapper;
	@Autowired
	private PageBean pageBean;
	@Override
	public Map<String, Object> add(Classroom room, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (mapper.add(room)>0) {
			map.put("code", "0");
			map.put("mag", "添加成功");
			map.put("data", room);
			return map;
		}else {
			map.put("code", "1");
			map.put("mag", "添加失败");
			map.put("data", null);
			return map;
		}
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
		int totalCount=mapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		//
		List<Classroom> listdata=mapper.getPageQueryList(pageBean);
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
	public Map<String, Object> update(Classroom room, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (mapper.update(room)>0) {
			map.put("code", "0");
			map.put("mag", "修改成功");
			map.put("data", room);
			return map;
		}else {
			map.put("code", "1");
			map.put("mag", "修改失败");
			map.put("data", null);
			return map;
		}
	}
	@Override
	public List<Classroom> getListClassesRoomName() {
		// TODO Auto-generated method stub
		List<Classroom> listdata=mapper.getListClassRoomName();
		System.out.println("数据"+listdata);
		if (!listdata.isEmpty()) {
			return listdata;
		}else {
			return null;
		}
		
	}
}
