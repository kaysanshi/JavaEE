package com.leo.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.leo.springmvc.dao.ItemDao;
import com.leo.springmvc.domain.Items;
import com.leo.springmvc.domain.ItemsExample;
import com.leo.springmvc.service.ItemService;
/**
 * service
 * @author leoi555
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Resource(name="itemdao")
	private ItemDao  itemdao;//相当于动态的mapper
	/**
	 * @return the itemdao
	 */
	public ItemDao getItemdao() {
		return itemdao;
	}
	/**
	 * @param itemdao the itemdao to set
	 */
	public void setItemdao(ItemDao itemdao) {
		this.itemdao = itemdao;
	}
	@Override
	public List<Items> getItemsList() {
		// TODO Auto-generated method stub
		return itemdao.getItemsList();
	}
	@Override
	public Items getItemById(String idInteger) {
		// TODO Auto-generated method stub
		return itemdao.getItemById(idInteger);
	}
	@Override
	public void updateItemById(Items items) {
		// TODO Auto-generated method stub
		itemdao.updateItemById(items);
	}
	@Override
	public void updateItemsByIdByQ(Items items) {
		// TODO Auto-generated method stub
		itemdao.updateItemById(items);
	}
	@Override
	public void deleteItemsByIdByQbyArray(Integer[] ids) {
		// TODO Auto-generated method stub
		itemdao.deleteItemsByIdByQbyArray(ids);
	}
	@Override
	public void updateItemsByIdByQList(List<Items> itemsList) {
		// TODO Auto-generated method stub
		itemdao.updateItemsByIdByQList(itemsList);
	}
	
}
