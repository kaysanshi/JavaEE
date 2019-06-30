package com.leo.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.e3mall.common.pojo.SearchResult;
import com.leo.e3mall.search.service.SearchItemService;
import com.leo.e3mall.utils.E3Result;

/**
 * 搜索功能
 * @author leoill
 *TODO
 *2019年1月19日
 */
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;
	
	@Value("${SEARCH_RESULT_ROWS}")
	private Integer SEARCH_RESULT_ROWS;

	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/index/item/import")
	@ResponseBody
	public E3Result importItemIndex() {
		E3Result result=searchItemService.importAllItem();
		return result;
	}
	/**
	 * 搜索页面
	 * @param keyword
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/search")
	@Deprecated
	public String searchItemList(String keyword, 
			@RequestParam(defaultValue="1") Integer page, Model model) throws Exception {
		keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
		//查询商品列表
		SearchResult searchResult = searchItemService.search(keyword, page, SEARCH_RESULT_ROWS);
		//把结果传递给页面
		model.addAttribute("query", keyword);
		model.addAttribute("totalPages", searchResult.getTotalPages());
		model.addAttribute("page", page);
		model.addAttribute("recourdCount", searchResult.getRecordCount());
		model.addAttribute("itemList", searchResult.getItemList());
		//异常测试
		//int a = 1/0;
		//返回逻辑视图
		return "search";
	}
	
}
