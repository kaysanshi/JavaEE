package com.leo.crm.dao.impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.leo.crm.dao.CustomerDao;
import com.leo.crm.domain.Customer;
/**
 * 操作Customer的数据访问
 * @author leoi555
 *
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
	@Override
	public Integer getTotalCount(DetachedCriteria dCriteria) {
		// TODO Auto-generated method stub
		//需要用聚合函数
		dCriteria.setProjection(Projections.rowCount());
		List list = getHibernateTemplate().findByCriteria(dCriteria);
		//清空聚合函数
		dCriteria.setProjection(null);
		if (list!=null && list.size()>0) {
			Long count=(Long) list.get(0);
			return count.intValue();//这是返回int性的
		}else {
			return null;
		}
	}

	@Override
	public List<Customer> getPageList(DetachedCriteria dCriteria, int start, Integer pageSize) {
		// TODO Auto-generated method stub
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dCriteria,start,pageSize);
		return list;
	}

}
