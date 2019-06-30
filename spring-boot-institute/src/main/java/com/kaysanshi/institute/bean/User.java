package com.kaysanshi.institute.bean;

import java.util.Date;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author kay三石
 *TODO
 *2019年4月5日-下午4:01:59
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;
	private String status;
	private String vercode;
	private String newpass;
	
	/**
	 * @return the newpass
	 */
	public String getNewpass() {
		return newpass;
	}

	/**
	 * @param newpass the newpass to set
	 */
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	/**
	 * @return the vercode
	 */
	public String getVercode() {
		return vercode;
	}

	/**
	 * @param vercode the vercode to set
	 */
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the addtime
	 */
	public Date getAddtime() {
		return addtime;
	}

	/**
	 * @param addtime the addtime to set
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String username, String password, Date addtime, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.addtime = addtime;
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", addtime=" + addtime
				+ ", status=" + status + "]";
	}
	
}
