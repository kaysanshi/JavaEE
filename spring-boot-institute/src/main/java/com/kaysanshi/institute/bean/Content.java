package com.kaysanshi.institute.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author kay三石
 *TODO
 *2019年4月5日-下午3:54:33
 */
public class Content {
	private Integer id;
	private String  title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;
	private String status;
	private Integer userid;
	private Integer categoryid;
	private String content;
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the categoryid
	 */
	public Integer getCategoryid() {
		return categoryid;
	}
	/**
	 * @param categoryid the categoryid to set
	 */
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Content(Integer id, String title, Date addtime, String status, Integer userid, Integer categoryid,
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.addtime = addtime;
		this.status = status;
		this.userid = userid;
		this.categoryid = categoryid;
		this.content = content;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", addtime=" + addtime + ", status=" + status + ", userid="
				+ userid + ", categoryid=" + categoryid + ", content=" + content + "]";
	}
}
