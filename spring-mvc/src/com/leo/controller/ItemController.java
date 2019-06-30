package com.leo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leo.domain.Items;


/**
 * 商品管理
 * 
 * @author lx
 *
 */
//配置控制器
@Controller
public class ItemController {
	//入门程序 第一 
	//返回给前端控制器的handler为：包类 + 类包 + 方法名
	//映射的访问路径
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList(){
		// 创建页面需要显示的商品数据
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		
		ModelAndView mav = new ModelAndView();
		//把数据加到map中这个addObject方法里面其实是封装的request.setAttribute()中了。
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	
}
