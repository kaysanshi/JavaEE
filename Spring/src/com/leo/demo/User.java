package com.leo.demo;

import javax.swing.event.InternalFrameAdapter;

import org.junit.validator.PublicClassValidator;

public class User {
	private String name;
	private String use;
	private int age;
	private Car car;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void init() {
		System.err.println("初始化");
	}
	public void destroy() {
		System.err.println("销毁");
	}
	/**
	 * 指定到这个构造：
	 * @param car
	 * @param name
	 */
	public User(Car car,String name) {
		this.car=car;
		this.name=name;
		System.out.println("car,name,");
	}
	/**
	 * 
	 * @param name
	 * @param car
	 */
	public User(String name,Car car) {
		this.car=car;
		this.name=name;
		System.out.println("name,car");
	}
	public User () {
		
	}
}
