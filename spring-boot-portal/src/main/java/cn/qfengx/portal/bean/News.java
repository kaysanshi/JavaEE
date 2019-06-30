package cn.qfengx.portal.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class News {
	private Integer id;
	private Integer ncid;
	private String title;
	private Integer click;
	private String detail;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;
	
	
	private String ncname;
	
	public String getNcname() {
		return ncname;
	}
	public void setNcname(String ncname) {
		this.ncname = ncname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNcid() {
		return ncid;
	}
	public void setNcid(Integer ncid) {
		this.ncid = ncid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", ncid=" + ncid + ", title=" + title + ", click=" + click + ", detail=" + detail
				+ ", addtime=" + addtime + ", ncname=" + ncname + "]";
	}
	
	
}
