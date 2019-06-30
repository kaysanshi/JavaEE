package com.leo.crm.action;

import java.util.List;

import com.leo.crm.domain.Customer;
import com.leo.crm.service.CustomerService;
import com.leo.crm.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 用户action
 * @author leoi555
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService service=new CustomerServiceImpl();
	 private Customer customer=new Customer();
	/**
	 * 获得列表
	 */
	public List<Customer> getList(){
		List<Customer> list=null;
		System.out.println("list");
		return list;
		
	}
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
}
