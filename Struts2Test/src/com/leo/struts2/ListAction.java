package com.leo.struts2;

import java.awt.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 集合类型的获取未能够获取
 * @author leoi555
 *
 */
public class ListAction  extends ActionSupport{
	private List list;
	private Map<String,Object> map;
	
	
	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public Map<String, Object> getMap() {
		return map;
	}


	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("list:"+list);
		System.out.println("map:"+map);
		return "success";
	}
	
}
