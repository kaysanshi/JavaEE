package com.leo.e3mall.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.e3mall.common.pojo.EasyUIDataGridResult;
import com.leo.e3mall.pojo.Item;
import com.leo.e3mall.service.ItemService;
import com.leo.e3mall.utils.E3Result;

/**
 * 商品管理
 * @author leoill
 *TODO
 *2019年1月2日
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * 以json的格式返回数据
	 * @param itemid
	 * @return
	 */
	@RequestMapping("/{itemid}")
	@ResponseBody
	public Item getItemById(@PathVariable Long itemid) {
		//去调用服务来操作
		Item item=itemService.getItemById(itemid);
		return item;
	}
	/**
	 * 获得商品分页列表，以json数据的格式返回出去
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows) {
		//调用服务查询商品列表
		EasyUIDataGridResult result=itemService.getItemList(page, rows);
		return result;
		
	}
	/**
	 * 商品的添加
	 * @param item
	 * @param desc
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(Item item,String desc) {
		E3Result addItem = itemService.addItem(item, desc);
		return addItem;
		
	}
}
