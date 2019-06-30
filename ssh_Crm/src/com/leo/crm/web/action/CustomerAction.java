package com.leo.crm.web.action;

import java.io.File;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.leo.crm.domain.Customer;
import com.leo.crm.service.CustomerService;
import com.leo.crm.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 操作user的Action
 * @author leoi555
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer;
	private CustomerService customerService;
	private Integer currentPage;
	private Integer pageSize;
	//后台提供name与属性相同的就可以
	private File photo;//接收文件
	private String photoContentType;//file类型mime类型
	private String photoFileName;//file 名称

	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * 获得列表
	 * @return
	 */
	public String list() {
		//封装离线查询对象
		DetachedCriteria  dCriteria=DetachedCriteria.forClass(Customer.class);
		if (org.apache.commons.lang3.StringUtils.isNotBlank(customer.getCust_name())) {
			dCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		PageBean bean=customerService.getPageBean(dCriteria,currentPage,pageSize);
		ActionContext.getContext().put("PageBean", bean);
		return "list";
	}
	/**
	 * 保存客户
	 * @param customer
	 * @return
	 */
	public String  saveCustomer(){
		if (photo!=null) {
			System.out.println("文件名称："+photoFileName);
			System.out.println("文件类型："+photoContentType);
			//将文件保存到指定的位置
			photo.renameTo(new File("/upload/photo.jpg"));
		}
		customerService.addCustomer(customer);
		return "toList";
	}
	/**
	 * 获取指定的用户
	 * @param id
	 * @return
	 */
	public String  getCutomerById() {
		Customer customer =customerService.getCustomerById(this.customer.getCust_id());
		System.out.println(customer.getCust_id()+customer.getCust_linkman());
		System.out.println(customer);
		//将客户放到request域
		ActionContext.getContext().put("customer", customer);
		return "edit";
	}
	public String deleteCustomer() {
		customerService.deleteCustomer(customer.getCust_id());
		return "toList";
	}
}
