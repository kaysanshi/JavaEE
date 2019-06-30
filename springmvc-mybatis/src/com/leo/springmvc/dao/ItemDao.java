package com.leo.springmvc.dao;

import java.util.List;

import com.leo.springmvc.domain.Items;
import com.leo.springmvc.domain.ItemsExample;
/**
 * 在这里相当于动态的mapper
 * @author leoi555
 *
 */
public interface ItemDao {
	/**
	 * 获得list列表
	 * @return
	 */
	public  List<Items> getItemsList();
	/**
	 * 获得单个列表
	 * @param idInteger
	 * @return
	 */
	public Items getItemById(String idInteger);
	/**
	 * 修改bypojo
	 * @param items
	 */
	public void updateItemById(Items items);
	/**
	 * 删除by数组
	 * @param ids
	 */
	public void deleteItemsByIdByQbyArray(Integer[] ids);
	/**
	 * 删除bylist
	 * @param itemsList
	 */
	public void updateItemsByIdByQList(List<Items> itemsList);

}
