package com.leo.bos.dao.Impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.leo.bos.dao.IRegionDao;
import com.leo.bos.dao.base.impl.BaseDaoImpl;
import com.leo.bos.domain.BcRegion;
import com.leo.bos.utils.PageBean;
/**
 * 
 * @author leoi555
 *
 */
@Repository
public class RegionDaoImpl extends BaseDaoImpl<BcRegion> implements IRegionDao {

	@Override
	public List<BcRegion> getListByQ(String q) {
		// TODO Auto-generated method stub
		String hql="FROM BcRegion r WHRER r.shotcode like :q or r.citycode like :q or province like :q or r.city like :q or district like :q";
		List<BcRegion>list=(List<BcRegion>) this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
		return list;
	}

	

}
