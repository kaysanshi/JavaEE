package com.leo.e3mall.content.service;
/**
 * 内容管理
 * @author leoill
 *TODO
 *2019年1月10日
 */

import java.util.List;

import com.leo.e3mall.pojo.Content;
import com.leo.e3mall.utils.E3Result;

public interface ContentService {
	/**
	 * 添加内容
	 * @param content
	 * @return
	 */
	E3Result addContent(Content content);
	/**
	 * 根据分类id查询所有的列表
	 * @param cid
	 * @return
	 */
	List<Content> getContentListByCid(long cid);

}
