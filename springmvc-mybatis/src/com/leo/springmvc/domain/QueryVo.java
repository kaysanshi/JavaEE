package com.leo.springmvc.domain;

import java.util.List;

public class QueryVo {

	
	//商品
	private Items items;
	Integer[] ids;
	
	private List<Items> itemsList;
	/**
	 * @return the ids
	 */
	public Integer[] getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	/**
	 * @return the itemsList
	 */
	public List<Items> getItemsList() {
		return itemsList;
	}

	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
}
