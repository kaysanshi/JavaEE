package com.leo.course.scheduling.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.course.scheduling.domain.Classroom;
import com.leo.course.scheduling.domain.Times;
import com.leo.course.scheduling.mapper.TimesMapper;
import com.leo.course.scheduling.service.TimesService;
import com.leo.course.scheduling.utils.PageBean;

/**
 * 
 * @author kay三石
 *TODO
 *2019年3月5日-下午7:34:09
 */
@Service("TimesServiceImpl")
@Transactional
public class TimesServiceImpl implements TimesService {
	@Autowired
	private TimesMapper timesMapper;
	
	@Autowired
	private PageBean pageBean;
	@Override
	public Map<String, Object> add(Times times, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		if (timesMapper.add(times)>0) {
			map.put("code", "0");
			map.put("msg", "添加成功");
			map.put("data", times);
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
				int totalCount=timesMapper.selectCount();
				System.out.println("总的记录数："+totalCount);
				//设置总页数
				pageBean.setTotal(totalCount);
				//分页
				//
				List<Classroom> listdata=timesMapper.getPageQueryList(pageBean);
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

}
