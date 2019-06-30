package com.leo.crm.service;

import java.util.List;

import com.leo.crm.domain.BaseDict;

/**
 * 
 * @author leoi555
 *
 */
public interface BaseDictService {
	/**
	 * 获得列表
	 * @param dict_type_code
	 * @return
	 */
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
