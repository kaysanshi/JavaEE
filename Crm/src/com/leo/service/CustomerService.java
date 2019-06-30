package com.leo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leo.domain.Customer;

/**
 *业务逻辑层
 * @author leoi555
 *
 */
public interface CustomerService {
	/**
	 * 添加客户
	 * @param customer
	 * @return
	 */
	boolean addCutomer(Customer customer);
	/**
	 * 获得客户列表
	 * @return
	 */
	List<Customer> getListCustomer();
	/**
	 *获得当前的客户
	 * @return
	 */
	Customer getCustomer(Customer customer);
	/**
	 * 保存修改
	 * @param customer
	 * @return
	 */
	boolean saveUpdate(Customer customer);
	/**
	 * 查询
	 * @param dc
	 * @return
	 */
	List<Customer> getAll(DetachedCriteria dc);
	/**
	 * 获得customer
	 * @param cust_id
	 * @return
	 */
	Customer getCustomerById(Long cust_id);
	

}
