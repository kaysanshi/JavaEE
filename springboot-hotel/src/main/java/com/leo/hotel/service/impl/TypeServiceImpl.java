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

import com.leo.hotel.domain.Region;
import com.leo.hotel.domain.Type;
import com.leo.hotel.domain.User;
import com.leo.hotel.mapper.TypeMapper;
import com.leo.hotel.service.TypeService;
import com.leo.hotel.utils.PageBean;
/**
 * 类型
 * @author leoill
 *TODO
 *2018年11月29日
 */
@Service(value="TypeServiceImpl")
@Transactional
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeMapper typeMapper;

	@Override
	public Map<String, Object> add(Type type, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res=new HashMap<>();
		if (typeMapper.add(type) > 0) {
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
	public Map<String, Object> update(Type type, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res=new HashMap<>();
		if (typeMapper.update(type) > 0) {
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
	public Map<String, Object> getPageList(Integer page, Integer rows, PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setCurrentPage((page-1)*rows);
		//设置每页页大小
		pageBean.setPageSize(rows);
		//查询总的记录数
		int totalCount=typeMapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		//
		List<Type> listdata=typeMapper.getPageQueryList(pageBean);
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
	public Map<String, Object> deleteType(String ids, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String , Object> map=new HashMap<>();
		if (Strings.isNotBlank(ids)) {
			String[] tids=ids.split(",");
			int i=0;
			//循环执行delete 语句
			for(String id:tids) {
				i=typeMapper.delete(id);
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
	public Map<String, Object> getTypeListByAjax(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<>();
		List<Type> list=typeMapper.getListByAjax();
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
