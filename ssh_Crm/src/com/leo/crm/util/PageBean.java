package com.leo.crm.util;

import java.util.List;
/**
 * pageBean
 * @author leoi555
 *
 */
public class PageBean {
	private Integer currentPage;//当前页
	private Integer totalCount;//总记录数
	private Integer pageSize;//每页显示
	private Integer totalPage;//总的页数
	private List list;//分页数据
	public PageBean(Integer curentPage,Integer totalCount,Integer pageSize) {
		// TODO Auto-generated constructor stub
		this.totalCount=totalCount;
		
		this.currentPage=curentPage;
		this.pageSize=pageSize;
		
		if (this.currentPage==null) {
			//如果页面没有指定哪一页显示第一页
			this.currentPage=1;
		}
		if (this.pageSize==null) {
			//显示每页的条数
			this.pageSize=3;
		}
		//计算总的页数
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		if (this.currentPage<1) {
			this.currentPage=1;
		}
		if (this.currentPage>this.totalPage) {
			this.currentPage=this.totalPage;
		}
	}
	//计算起始索引
	public int getStart(){
		return (this.currentPage-1)*this.pageSize;
	}
	public Integer getCurentPage() {
		return currentPage;
	}
	public void setCurentPage(Integer curentPage) {
		this.currentPage = curentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	

}
