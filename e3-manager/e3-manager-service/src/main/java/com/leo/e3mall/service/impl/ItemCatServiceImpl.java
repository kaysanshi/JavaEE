package com.leo.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.Node;
import com.leo.e3mall.common.pojo.EasyUiTreeNote;
import com.leo.e3mall.mapper.ItemCatMapper;
import com.leo.e3mall.pojo.ItemCat;
import com.leo.e3mall.pojo.ItemCatExample;
import com.leo.e3mall.pojo.ItemExample;
import com.leo.e3mall.pojo.ItemCatExample.Criteria;
import com.leo.e3mall.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private ItemCatMapper mapper;
	@Override
	public List<EasyUiTreeNote> getItemCatList(long parentId) {
		// TODO Auto-generated method stub
		//根据parentId查询子节点的列表
		ItemCatExample example=new ItemCatExample();
		Criteria criteria=example.createCriteria();
		//设置查询条件
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<ItemCat> list=mapper.selectByExample(example);
		//创建返回结果的list
		List<EasyUiTreeNote> result=new ArrayList<>();
		//把返回结果的列表转换为EasyUITreeNode列表
		for(ItemCat itemCat:list) {
			EasyUiTreeNote node=new EasyUiTreeNote();
			//设置属性
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			//返回的boolean型的然后直接判断是否true，然后是为closed,open
			node.setState(itemCat.getIsParent()?"closed":"open");
			result.add(node);
		}
		return result;
	}

}
