package com.leo.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leo.crm.domain.Customer;
/**
 * 接口继承BaseDao接口后就无需再声明已经写过的方法
 * @author leoi555
 *
 */
public interface CustomerDao extends BaseDao<Customer>{
	/**
	 * 查询总的记录数
	 * @param dCriteria
	 * @return
	 */
	Integer  getTotalCount(DetachedCriteria dCriteria);
	/**
	 * 分页
	 * @param dCriteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<Customer> getPageList(DetachedCriteria dCriteria, int start, Integer pageSize);

}
