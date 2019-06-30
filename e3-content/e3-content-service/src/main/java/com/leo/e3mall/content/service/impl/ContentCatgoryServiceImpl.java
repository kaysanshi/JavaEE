package com.leo.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.e3mall.common.pojo.EasyUiTreeNote;
import com.leo.e3mall.content.service.ContentCatgoryService;
import com.leo.e3mall.mapper.ContentCategoryMapper;
import com.leo.e3mall.pojo.Content;
import com.leo.e3mall.pojo.ContentCategory;
import com.leo.e3mall.pojo.ContentCategoryExample;
import com.leo.e3mall.pojo.ContentCategoryExample.Criteria;
import com.leo.e3mall.utils.E3Result;
/**
 * 内容管理
 * @author leoill
 *TODO
 *2019年1月8日
 */
@Service
public class ContentCatgoryServiceImpl implements ContentCatgoryService{
	
	@Autowired
	private  ContentCategoryMapper mapper;
	
	@Override
	public List<EasyUiTreeNote> getContentCatList(long parentId) {
		// TODO Auto-generated method stub
		//根据parentId查询子节点
		ContentCategoryExample example=new ContentCategoryExample();
		//设置查询条件
		Criteria criteria=example.createCriteria();
		criteria.andParentIdNotEqualTo(parentId);
		//执行查询
		List<ContentCategory> list = mapper.selectByExample(example);
		//转换成EasyUItreeNode
		List<EasyUiTreeNote> nodeList=new ArrayList<>();
		for(ContentCategory category:list) {
			EasyUiTreeNote node=new EasyUiTreeNote();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent()?"closed":"open");
			//添加到列表
			nodeList.add(node);
		}
		return nodeList;
	}

	@Override
	public E3Result addContentCategory(long parentId, String name) {
		// TODO Auto-generated method stub
		//创建一个tb_content_category表对应的pojo对象
		ContentCategory category=new ContentCategory();	
		//设置pojo的属性
		category.setParentId(parentId);
		category.setName(name);
		//设置状态1.(正常) 2(删除)
		category.setStatus(1);
		//设置默认排序为1
		category.setSortOrder(1);
		//新增的节点一定为叶子节点
		category.setIsParent(false);
		category.setCreated(new Date());
		category.setUpdated(new Date());
		//插入到数据库中
		mapper.insert(category);
		//判断父节点的isparent属性，如果不是true改为true
		//根据parentId查询父节点
		ContentCategory selectByPrimaryKey = mapper.selectByPrimaryKey(parentId);
		if (selectByPrimaryKey.getIsParent()) {
			selectByPrimaryKey.setIsParent(true);
			//更新到数据库中
			mapper.updateByPrimaryKey(selectByPrimaryKey);
		}
		//返回结果 返E3result包含pojo
		return E3Result.ok(category);
	}

}
