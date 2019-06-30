package com.leo.bos.dao.Impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.leo.bos.dao.ISubareaDao;
import com.leo.bos.dao.base.impl.BaseDaoImpl;
import com.leo.bos.domain.BcSubarea;

/**
 * 分区
 * @author leoi555
 *
 */
@Repository
public class SubareaDaoImpl extends BaseDaoImpl<BcSubarea> implements ISubareaDao{

	@Override
	public List<Object> findSubareaGroupByProvince() {
		// TODO Auto-generated method stub
		String hql="Select r.province,count(*) FROM Subarea s left OUTER JOIN s.region r Group by r.province";
		return (List<Object>) this.getHibernateTemplate().find(hql);
	}

	

}
