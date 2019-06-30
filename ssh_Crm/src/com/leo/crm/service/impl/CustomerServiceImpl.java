package com.leo.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.support.DaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.leo.crm.dao.CustomerDao;
import com.leo.crm.domain.Customer;
import com.leo.crm.service.CustomerService;
import com.leo.crm.util.PageBean;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	@Override
	public PageBean getPageBean(DetachedCriteria  dCriteria, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		//查询总记录数
		int totalCount=customerDao.getTotalCount(dCriteria);
		//创建PageBean对象
		PageBean pageBean=new PageBean(currentPage, totalCount, pageSize);
		//调用分页
		List<Customer> list =customerDao.getPageList(dCriteria,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		//
		return pageBean;
	}
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		//1.维护Customer与数据字典对象的关系
			//调用dao取出数据字典，将数据字典设置到对象的属性中，struts2会将参数封装到数据字典的id使用游离对象
		//无需维护
		//2.调用dao层保存客户
		customerDao.saveOrUpdate(customer);
	}
	@Override
	public Customer getCustomerById(long cust_id) {
		// TODO Auto-generated method stub
		return customerDao.getById(cust_id);
	}
	@Override
	public void deleteCustomer(long cust_id) {
		// TODO Auto-generated method stub
		customerDao.delete(cust_id);
	}

}
