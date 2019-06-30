package com.leo.e3mall.service;

import java.util.List;

import com.leo.e3mall.common.pojo.EasyUiTreeNote;

public interface ItemCatService {
	//获得的树形分类
	List<EasyUiTreeNote> getItemCatList(long parentId);
}
