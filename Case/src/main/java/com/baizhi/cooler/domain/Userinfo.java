package com.baizhi.cooler.domain;
// Generated 2018-11-3 16:12:45 by Hibernate Tools 5.3.0.Beta2

/**
 * Userinfo generated by hbm2java
 */
public class Userinfo implements java.io.Serializable {

	private int id;
	private String title;
	private String context;
	private String gender;
	private String email;
	private String telephone;
	private String phone;
	private String companyName;
	private String address;
	private String isconnection;
	private String addtime;

	/**
	 * @return the addtime
	 */
	public String getAddtime() {
		return addtime;
	}

	/**
	 * @param addtime the addtime to set
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public Userinfo() {
	}

	public Userinfo(int id) {
		this.id = id;
	}

	public Userinfo(int id, String title, String context, String gender, String email, String telephone, String phone,
			String companyName, String address, String isconnection) {
		this.id = id;
		this.title = title;
		this.context = context;
		this.gender = gender;
		this.email = email;
		this.telephone = telephone;
		this.phone = phone;
		this.companyName = companyName;
		this.address = address;
		this.isconnection = isconnection;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsconnection() {
		return this.isconnection;
	}

	public void setIsconnection(String isconnection) {
		this.isconnection = isconnection;
	}

}
