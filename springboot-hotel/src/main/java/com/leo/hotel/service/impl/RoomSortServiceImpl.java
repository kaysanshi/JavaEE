package com.leo.hotel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.hotel.domain.Roomsort;
import com.leo.hotel.domain.Type;
import com.leo.hotel.mapper.RoomSortMapper;
import com.leo.hotel.service.RoomSortService;
import com.leo.hotel.utils.PageBean;
/**
 * 房间分类
 * @author leoill
 *TODO
 *2018年11月30日
 */
@Service("RoomSortServiceImpl")
@Transactional
public class RoomSortServiceImpl implements RoomSortService{
	@Autowired
	private RoomSortMapper sortMapper;

	@Override
	public Map<String, Object> add(Roomsort sort, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res=new HashMap<>();
		if (sortMapper.add(sort) > 0) {
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
	public Map<String, Object> update(Roomsort sort, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res=new HashMap<>();
		if (sortMapper.update(sort) > 0) {
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
	public Map<String, Object> deleteSort(String ids, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String , Object> map=new HashMap<>();
		if (Strings.isNotBlank(ids)) {
			String[] tids=ids.split(",");
			int i=0;
			//循环执行delete 语句
			for(String id:tids) {
				i=sortMapper.delete(id);
			}
			if (i>0) {
				map.put("code", '0');
				map.put("message", "删除成功");
				map.put("data", null);
			}else {
				map.put("code", '1');
				map.put("message", "删除失败");
				map.put("data", null);
			}
 		}
		return map;
	}

	@Override
	public Map<String, Object> getPageList(Integer page, Integer rows, PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setCurrentPage((page-1)*rows);
		//设置每页页大小
		pageBean.setPageSize(rows);
		//查询总的记录数
		int totalCount=sortMapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		//
		List<Roomsort> listdata=sortMapper.getPageQueryList(pageBean);
		pageBean.setRows(listdata);
		System.out.println("数据"+listdata);
		Map<String, Object> map=new HashMap<>();
		if (!listdata.isEmpty()) {
			map.put("total", pageBean.getTotal());
			map.put("rows", pageBean.getRows());
			return map;
		}else {
			map.put("msg", "获取失败");
			map.put("code", "0");
			map.put("data", null);
			return map;
		}
	}

	@Override
	public Map<String, Object> getSortListByAjax(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<>();
		List<Roomsort> list=sortMapper.getListByAjax();
		if (!list.isEmpty()) {
			map.put("msg", "获取成功");
			map.put("code", "0");
			map.put("data", list);
		}else {
			map.put("msg", "获取失败");
			map.put("code", "0");
			map.put("data", null);
		}
		return map;
	}
}
