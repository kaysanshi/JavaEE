package com.leo.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

//@Component("user")
//	@Service("user")//service层
//	@Controller("user")//web层
//	@Repository("user")//dao层
	@Scope(scopeName="singleton|protptype")//指定对象的作用域
public class UserAnnotation {
	@Value("lll")
	private String name;
	@Value("12")
	private Integer age;
	private String 	sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
