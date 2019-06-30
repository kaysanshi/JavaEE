package com.leo.crm.service.impl;

import java.util.List;

import com.leo.crm.dao.BaseDictDao;
import com.leo.crm.domain.BaseDict;
import com.leo.crm.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{
	private BaseDictDao baseDictDao;
	
	public BaseDictDao getBaseDictDao() {
		return baseDictDao;
	}

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		return baseDictDao.getListByTypeCode(dict_type_code);
	}

}
