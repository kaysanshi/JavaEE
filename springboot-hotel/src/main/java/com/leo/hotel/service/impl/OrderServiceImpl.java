package com.leo.hotel.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.hotel.domain.Order;
import com.leo.hotel.domain.User;
import com.leo.hotel.mapper.OrderMapper;
import com.leo.hotel.service.OrderService;
import com.leo.hotel.utils.PageBean;
@Service("OrderServiceImpl")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Map<String, Object> addOrder(Order order, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String , Object> map=new HashMap<>();
		
		order.setUserid((int) request.getSession().getAttribute("loginUserid"));
		order.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		int stats=orderMapper.addOrder(order);
		if (stats>0) {
			map.put("msg", "下单成功");
			map.put("code", "0");
			map.put("data", null);
			return map;
		}else {
			map.put("msg", "保存失败");
			map.put("code", "1");
			map.put("data", null);
			return map;
		}
	}

	@Override
	public Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean) {
		// TODO Auto-generated method stub
		//设置开始当前页
				pageBean.setCurrentPage((page-1)*rows);
				//设置每页页大小
				pageBean.setPageSize(rows);
				//查询总的记录数
				int totalCount=orderMapper.selectCount();
				System.out.println("总的记录数："+totalCount);
				//设置总页数
				pageBean.setTotal(totalCount);
				//分页
				//
				List<Order> listdata=orderMapper.getPageQueryList(pageBean);
				pageBean.setRows(listdata);
				System.out.println("数据"+listdata.toString());
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
	
}
