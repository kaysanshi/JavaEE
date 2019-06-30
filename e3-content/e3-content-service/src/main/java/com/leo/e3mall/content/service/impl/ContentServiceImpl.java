package com.leo.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.leo.e3mall.common.jedis.JedisClient;
import com.leo.e3mall.content.service.ContentService;
import com.leo.e3mall.mapper.ContentMapper;
import com.leo.e3mall.pojo.Content;
import com.leo.e3mall.pojo.ContentExample;
import com.leo.e3mall.pojo.ContentExample.Criteria;
import com.leo.e3mall.utils.E3Result;
import com.leo.e3mall.utils.JsonUtils;

@Service
public class ContentServiceImpl implements ContentService{
	
	@Autowired
	private ContentMapper contentMapper;
	
	@Autowired
	private JedisClient jedisClient;
	@Value("CONTENT_LIST")
	private String CONTENT_LIST;
	/**
	 * 增加的使用
	 */
	@Override
	public E3Result addContent(Content content) {
		// TODO Auto-generated method stub
		//将内容数据插入到内容表
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入到数据库中
		contentMapper.insert(content);
		//做缓存同步，删除缓存对应的数据，（hash表不可以删除）
		jedisClient.hdel(CONTENT_LIST, String.valueOf(content.getCategoryId()));
		return E3Result.ok();
	}
	/**
	 * 带缓存的添加
	 */
	@Override
	public List<Content> getContentListByCid(long cid) {
		// TODO Auto-generated method stub
		//先查询缓存
		try {
			//如果缓存中有数据则直接响应
			String json=jedisClient.hget(CONTENT_LIST, cid+"");
			if (StringUtils.isNotBlank(json)) {
				List<Content> list=JsonUtils.jsonToList(json, Content.class);
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ContentExample example=new ContentExample();
		//设置查询条件
		Criteria criteria=example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		//根据大文本信息查询
		List<Content> list = contentMapper.selectByExampleWithBLOBs(example);
		//把结果添加到缓存中 
		jedisClient.hset(CONTENT_LIST, cid+"", JsonUtils.objectToJson(list));
		return list;
	}

}
