package com.leo.crm.service.impl;

import com.leo.crm.dao.CustomerDao;
import com.leo.crm.dao.impl.CustomerDaoimpl;
import com.leo.crm.service.CustomerService;

/**
 * service层
 * @author leoi555
 *
 */
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao=new CustomerDaoimpl(); 
	

}
