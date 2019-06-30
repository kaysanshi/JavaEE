package com.leo.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leo.e3mall.common.jedis.JedisClient;
import com.leo.e3mall.common.pojo.EasyUIDataGridResult;
import com.leo.e3mall.mapper.ItemDescMapper;
import com.leo.e3mall.mapper.ItemMapper;
import com.leo.e3mall.pojo.Item;
import com.leo.e3mall.pojo.ItemDesc;
import com.leo.e3mall.pojo.ItemDescExample;
import com.leo.e3mall.pojo.ItemExample;
import com.leo.e3mall.pojo.ItemExample.Criteria;
import com.leo.e3mall.service.ItemService;
import com.leo.e3mall.utils.E3Result;
import com.leo.e3mall.utils.IDUtils;
import com.leo.e3mall.utils.JsonUtils;

import org.apache.commons.lang3.StringUtils;

/**
 * 商品的管理页面
 * @author leoill
 *TODO
 *2019年1月2日
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemdao;
	@Autowired
	private ItemDescMapper descMapper;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination topicDestination;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_ITEM_PRE}")
	private String REDIS_ITEM_PRE;
	@Value("${ITEM_CACHE_EXPIRE}")
	private Integer ITEM_CACHE_EXPIRE;
	@Override
	public Item getItemById(long itemId) {
		// TODO Auto-generated method stub
	//根据主键查询
		//设置条件查询
		ItemExample example=new ItemExample();
		Criteria criteria=example.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(itemId);
		//执行查询
		List<Item> list=itemdao.selectByExample(example);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}


	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		//设置开始页，和也大小
		PageHelper.startPage(page, rows);
		//执行查询
		ItemExample example=new ItemExample();
		List<Item> list = itemdao.selectByExample(example);
		//设置结果
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		result.setRows(list);
		//分页结果
		PageInfo<Item> pageInfo=new PageInfo<>(list);
		//取总的记录数
		long total=pageInfo.getTotal();
		result.setTotal(total);
		return result;
		
		
	}
	@Override
	public E3Result addItem(Item item, String desc) {
		// TODO Auto-generated method stub
		//生成商品id，
		long itemid=IDUtils.genItemId();
		//补全item的属性
		item.setId(itemid);
		//1:正常,2:下架，3:删除
		//项商品中添加数据
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//创建一个商品描述的对应的pojo
		ItemDesc itemDesc=new ItemDesc();
		//补全属性
		itemDesc.setItemId(itemid);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		//向商品描述插入数据
		descMapper.insert(itemDesc);
		//返回成功
		return E3Result.ok();
	}


	@Override
	public ItemDesc getItemDescById(long itemId) {
		//查询缓存
				try {
					String json = jedisClient.get(REDIS_ITEM_PRE + ":" + itemId + ":DESC");
					if(StringUtils.isNotBlank(json)) {
						ItemDesc tbItemDesc = JsonUtils.jsonToPojo(json, ItemDesc.class);
						return tbItemDesc;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ItemDesc itemDesc = descMapper.selectByPrimaryKey(itemId);
				//把结果添加到缓存
				try {
					jedisClient.set(REDIS_ITEM_PRE + ":" + itemId + ":DESC", JsonUtils.objectToJson(itemDesc));
					//设置过期时间
					jedisClient.expire(REDIS_ITEM_PRE + ":" + itemId + ":DESC", ITEM_CACHE_EXPIRE);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return itemDesc;
	}

}
