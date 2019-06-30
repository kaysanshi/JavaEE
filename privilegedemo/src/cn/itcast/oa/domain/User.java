package cn.itcast.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体
 * @author zhaoqx
 *
 */

public class User {
	private Long id;
	private String loginName;
	private String name;
	private Integer gender;
	private String phoneNumber;
	private String email;
	private String description;
	private String password;
	private Department department;
	private Set<Role> roles = new HashSet<Role>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	/**
	 * 验证权限是否存在
	 */
	public boolean checkPrivilegeByName(String name){
		if(isAdmin()){
			return true;
		}
		System.out.println("验证当前登录用户是否有权限：" + name);
		for(Role r : roles){
			for(Privilege p : r.getPrivileges()){
				if(name.equals(p.getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 验证权限对应的url是否存在
	 */
	public boolean checkPrivilegeByUrl(String url) {
		if(isAdmin()){
			return true;
		}
		for(Role r : roles){
			for(Privilege p : r.getPrivileges()){
				if(url.equals(p.getUrl())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断当前登录用户是否是超级管理员
	 * 直接判断是否登录录名为admin程序中直接写实了
	 */
	public boolean isAdmin(){
		return "admin".equals(loginName);
	}
}
