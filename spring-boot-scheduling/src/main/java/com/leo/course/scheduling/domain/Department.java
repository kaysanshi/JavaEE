package com.leo.course.scheduling.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Department {
	private Integer id;
	private String depno;
	private String depname;
	private String majorno;
	private String majorname;
	private String flag;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;
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
	 * @return the depno
	 */
	public String getDepno() {
		return depno;
	}
	/**
	 * @param depno the depno to set
	 */
	public void setDepno(String depno) {
		this.depno = depno;
	}
	/**
	 * @return the depname
	 */
	public String getDepname() {
		return depname;
	}
	/**
	 * @param depname the depname to set
	 */
	public void setDepname(String depname) {
		this.depname = depname;
	}
	/**
	 * @return the majorno
	 */
	public String getMajorno() {
		return majorno;
	}
	/**
	 * @param majorno the majorno to set
	 */
	public void setMajorno(String majorno) {
		this.majorno = majorno;
	}
	/**
	 * @return the majorname
	 */
	public String getMajorname() {
		return majorname;
	}
	/**
	 * @param majorname the majorname to set
	 */
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	public Department(Integer id, String depno, String depname, String majorno, String majorname, String flag,
			Date addtime) {
		super();
		this.id = id;
		this.depno = depno;
		this.depname = depname;
		this.majorno = majorno;
		this.majorname = majorname;
		this.flag = flag;
		this.addtime = addtime;
	}
	/**
	 * 没有这这个构造函数，为何不能默认加入呢
	 */
	public Department() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id=" + id + ", depno=" + depno + ", depname=" + depname + ", majorno=" + majorno
				+ ", majorname=" + majorname + ", flag=" + flag + ", addtime=" + addtime + "]";
	}
	
	
}
