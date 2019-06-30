package com.leo.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.leo.dao.CustomerDao;
import com.leo.dao.impl.CustomerDaoImpl;
import com.leo.domain.Customer;
import com.leo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao=new CustomerDaoImpl();

	@Override
	public boolean addCutomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.addCustomer(customer);
	}

	@Override
	public List<Customer> getListCustomer() {
		// TODO Auto-generated method stub
		return dao.getListCustomer();
	}

	@Override
	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.getCustomer(customer);
	}

	@Override
	public boolean saveUpdate(Customer customer) {
		// TODO Auto-generated method stub
		return dao.saveUpdate(customer);
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return dao.getAll(dc);
	}

	@Override
	public Customer getCustomerById(Long cust_id) {
		// TODO Auto-generated method stub
		return dao.getCustomerById(cust_id);
	}
}
