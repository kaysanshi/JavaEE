package com.leo.bean;
/**
 * 持久化类
 * @author leoi555
 *
 */
public class Employee {
	 public int id;
	 private String firstname;
	 private String lastname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	 
}
