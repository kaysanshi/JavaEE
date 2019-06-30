package com.kaysanshi.institute.bean;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author kay三石
 *TODO
 *2019年4月5日-下午3:46:19
 */
public class Category {
	private Integer id;
	private Integer pid;
	private String url;
	private String name;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;
	private String status;
	
	private List<Category> sublist;
	
	
	/**
	 * @return the sublist
	 */
	public List<Category> getSublist() {
		return sublist;
	}

	/**
	 * @param category the sublist to set
	 */
	public void setSublist(List<Category> category) {
		this.sublist = category;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(Integer id, Integer pid, String url, String name, String description, Date addtime,
			String status) {
		super();
		this.id = id;
		this.pid = pid;
		this.url = url;
		this.name = name;
		this.description = description;
		this.addtime = addtime;
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", pid=" + pid + ", url=" + url + ", name=" + name + ", description="
				+ description + ", addtime=" + addtime + ", status=" + status + ", sublist=" + sublist + "]";
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
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
}
