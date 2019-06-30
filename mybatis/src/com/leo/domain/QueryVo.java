package com.leo.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 进行包装类型的演示
 * @author leoi555
 *
 */
public class QueryVo implements Serializable{
	//
	private User user;
	List<Integer> list;//通过list集合
	Integer[] arrays;//通过数组
	List<Integer> listinter;
	
	/**
	 * @return the listinter
	 */
	public List<Integer> getListinter() {
		return listinter;
	}

	/**
	 * @param listinter the listinter to set
	 */
	public void setListinter(List<Integer> listinter) {
		this.listinter = listinter;
	}

	/**
	 * @return the list
	 */
	public List<Integer> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Integer> list) {
		this.list = list;
	}

	
	/**
	 * @return the arrays
	 */
	public Integer[] getArrays() {
		return arrays;
	}

	/**
	 * @param arrays the arrays to set
	 */
	public void setArrays(Integer[] arrays) {
		this.arrays = arrays;
	}



	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	

}
