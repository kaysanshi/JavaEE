package com.leo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leo.domain.Customer;

public interface CustomerDao {
	/**
	 * 添加用户
	 * @param customer
	 * @return
	 */
	boolean addCustomer(Customer customer);
	/**
	 * 用户列表
	 * @return
	 */
	List<Customer> getListCustomer();
	/**
	 * 获得customer对象
	 * @return
	 */
	Customer getCustomer(Customer customer);
	/**
	 * 保存更改后的对象
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
	 * 获得单个用户
	 * @param cust_id
	 * @return
	 */
	Customer getCustomerById(Long cust_id);

}
