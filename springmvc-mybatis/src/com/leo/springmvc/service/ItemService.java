package com.leo.springmvc.service;
/**
 * 
 * @author leoi555
 *
 */

import java.util.List;

import com.leo.springmvc.domain.Items;
import com.leo.springmvc.domain.ItemsExample;

public interface ItemService {
	public List<Items> getItemsList();
	/**
	 * 通过id查询
	 * @param idInteger
	 * @return
	 */
	public Items getItemById(String idInteger);
	/**
	 * 修改
	 * @param items
	 */
	public void updateItemById(Items items);
	/**
	 * 包装类实现修改
	 * @param items
	 */
	public void updateItemsByIdByQ(Items items);
	/**
	 * 包装类的数组类型的
	 * @param ids
	 */
	public void deleteItemsByIdByQbyArray(Integer[] ids);
	/**
	 * 包装类的list的
	 * @param itemsList
	 */
	public void updateItemsByIdByQList(List<Items> itemsList);
}
