package com.leo.e3mall.content.service;
/**
 * 内容分类管理
 * @author leoill
 *TODO
 *2019年1月8日
 */

import java.util.List;

import com.leo.e3mall.common.pojo.EasyUiTreeNote;
import com.leo.e3mall.utils.E3Result;

public interface ContentCatgoryService {
	/**
	 * 获取内容管理
	 * @param parentId
	 * @return
	 */
	List<EasyUiTreeNote> getContentCatList(long parentId);
	
	E3Result addContentCategory(long parentId,String name);
}
