package com.leo.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.hotel.domain.Order;
import com.leo.hotel.service.OrderService;
import com.leo.hotel.utils.JavaToJSon;
import com.leo.hotel.utils.PageBean;

/**
 * 订单
 * @author leoill
 *TODO
 *2018年12月2日
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	@Qualifier("OrderServiceImpl")
	private OrderService orderService;
	@Autowired
	private PageBean pageBean;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> addOrder(Order order,HttpServletResponse response,HttpServletRequest request){
		
		return orderService.addOrder(order,request,response);

	}
	@RequestMapping("/list")
	@ResponseBody
	public void getList(@RequestParam(name="page", required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,Order order,HttpServletResponse response,HttpServletRequest request){
		
		Map<String, Object> map=new HashMap<>();
		//设置当前页
		pageBean.setCurrentPage(page);
		//设置页大小
		pageBean.setPageSize(rows);
		System.out.println("当前页："+page);
		System.out.println("显示的行数："+rows);
		map=orderService.getList(page,rows,pageBean);
		System.out.println("列表zzz："+map.get("rows"));
		JavaToJSon.ResponseToJson(response, map);
	}
}
