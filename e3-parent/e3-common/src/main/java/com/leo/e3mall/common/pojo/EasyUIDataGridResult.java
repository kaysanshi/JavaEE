package com.leo.e3mall.common.pojo;

import java.io.Serializable;
/**
 * 用于返回分页查询的参数
 * @author leoill
 *TODO
 *2019年1月4日
 */
import java.util.List;


public class EasyUIDataGridResult implements Serializable{
	private long total;
	private List rows;
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the rows
	 */
	public List getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
