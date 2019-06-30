package com.leo.struts2;

import com.opensymphony.xwork2.ActionSupport;
/**
 * action普通的Java类
 * @author leoi555
 *
 */
public class HelloWordAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "SUCCESS";
	}

	public HelloWordAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
