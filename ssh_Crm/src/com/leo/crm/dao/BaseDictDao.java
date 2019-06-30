package com.leo.crm.dao;

import java.util.List;

import com.leo.crm.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{
	/**
	 * 根据数据字典来获得
	 * @param dict_type_code
	 * @return
	 */
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
