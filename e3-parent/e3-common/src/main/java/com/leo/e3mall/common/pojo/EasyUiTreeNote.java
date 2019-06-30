package com.leo.e3mall.common.pojo;

import java.io.Serializable;

public class EasyUiTreeNote implements Serializable{
	private Long id;
	private String text;
	private String state;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param long1 the id to set
	 */
	public void setId(Long long1) {
		this.id = long1;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
}
