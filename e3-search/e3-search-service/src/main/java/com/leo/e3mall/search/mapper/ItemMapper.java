package com.leo.e3mall.search.mapper;

import java.util.List;

import com.leo.e3mall.common.pojo.SearchItem;

public interface ItemMapper {
	/**
	 * 搜索商品
	 * @return
	 */
	List<SearchItem> getItemList();

}
