package com.leo.e3mall.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.e3mall.common.pojo.EasyUiTreeNote;
import com.leo.e3mall.service.ItemCatService;

/**
 * 商品分类管理
 * @author leoill
 *TODO
 *2019年1月5日
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService catService;
	
	/**
	 * 加载树形的
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUiTreeNote> getItemCatList(@RequestParam(name="id",defaultValue="0")Long parentId){
		//调用服务查询节点列表
		List<EasyUiTreeNote> list=catService.getItemCatList(parentId);
		return list;	
	} 
}
