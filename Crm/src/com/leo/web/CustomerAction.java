package com.leo.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Update;
import org.junit.Test;

import com.leo.domain.Customer;
import com.leo.domain.User;
import com.leo.service.CustomerService;
import com.leo.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer=new Customer();
	private CustomerService service=new CustomerServiceImpl();
	public String test() {
		System.out.println("test...");
		return Action.NONE;
	}
	
	public String list() throws Exception {
		//1 接受参数
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		//2 创建离线查询对象
		DetachedCriteria dc =DetachedCriteria.forClass(Customer.class);
		//3 判断参数拼装条件
		if(StringUtils.isNotBlank(cust_name)){
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		//4 调用Service将离线对象传递
		List<Customer> list = service.getAll(dc);
		//5 将返回的list放入request域.转发到list.jsp显示
		
		//ServletActionContext.getRequest().setAttribute("list", list);
		
		// 放到ActionContext
		ActionContext.getContext().put("list", list);
		
		
		return "list";
	}
	/**
	 * 获得
	 * @return
	 */
	public String getCustomer() {
		Customer customer=service.getCustomerById(this.customer.getCust_id());
		ActionContext.getContext().put("customer", customer);
		return "edit";
	}

	//添加客户
	public String add() throws Exception {
		System.out.println("add方法：");
		//1 调用Service
		service.addCutomer(customer);
		//2 重定向到列表action方法
		return "toList";   
	}
	//修改客户
	public String update() throws Exception {
		System.out.println("修改");
		Customer user =service.getCustomer(customer);
		ActionContext.getContext().put("customer", user);
		return "customer";
	}
	//保存修改的客户
	public String save() {
		service.saveUpdate(customer);
		return "toList";
	}
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
}
