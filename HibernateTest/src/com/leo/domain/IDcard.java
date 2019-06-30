package com.leo.domain;
/**
 * 主键一对多的实例
 * @author leoi555
 *
 */
public class IDcard {
	private int id;
	private String IDCode;
	private People people;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIDCode() {
		return IDCode;
	}
	public void setIDCode(String iDCode) {
		IDCode = iDCode;
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
}
