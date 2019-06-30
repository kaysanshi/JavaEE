package com.leo.crm.service;

import javax.jws.WebService;

import org.hibernate.criterion.DetachedCriteria;

import com.leo.crm.domain.Customer;
import com.leo.crm.util.PageBean;

/**
 * 为外部提供服务
 * @author leoi555
 *
 */
@WebService
public interface CustomerService {
	/**
	 * 分页
	 * @param customer
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria  dCriteria, Integer currentPage, Integer pageSize);
	/**
	 * 添加客户
	 * @param customer
	 */
	void addCustomer(Customer customer);
	/**
	 * 获得
	 * @param cust_id
	 * @return
	 */
	Customer getCustomerById(long cust_id);
	/**
	 * 删除
	 * @param cust_id
	 */
	void deleteCustomer(long cust_id);

}
