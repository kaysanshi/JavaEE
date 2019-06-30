package cn.itcast.core.dao;

import java.util.List;

import cn.itcast.core.bean.Customer;

public interface CustomerDao {
	/**
	 * 查询客户列表条件
	 * @param customer
	 * @return
	 */
	List<Customer> selectCustomerList(Customer customer);
	/**
	 * 获得出巡的总的记录数
	 * @param customer
	 * @return
	 */
	Integer selectCustomerListCount(Customer customer);
	/**
	 * 获得单个的对象
	 * @param id
	 * @return
	 */
	Customer getCustomerById(Long id);
	/**
	 * 修改
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * 删除
	 * @param id
	 */
	void deleteCustomer(Long id);
	
}