package com.leo.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.leo.crm.dao.BaseDictDao;
import com.leo.crm.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao{

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		//创建离线查询对象
		DetachedCriteria dCriteria=DetachedCriteria.forClass(BaseDict.class);
		//封装条件
		dCriteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		//执行条件
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dCriteria);
		return list;
	}

	

}
