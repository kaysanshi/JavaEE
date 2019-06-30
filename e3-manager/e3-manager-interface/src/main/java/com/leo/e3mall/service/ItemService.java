package com.leo.e3mall.service;

import com.leo.e3mall.common.pojo.EasyUIDataGridResult;
import com.leo.e3mall.pojo.Item;
import com.leo.e3mall.pojo.ItemDesc;
import com.leo.e3mall.utils.E3Result;

/**
 * item
 * @author leoill
 *TODO
 *2019年1月2日
 */
public interface ItemService {
	
	Item getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page, int rows);
	E3Result addItem(Item item, String desc);
	ItemDesc getItemDescById(long itemId);
}
