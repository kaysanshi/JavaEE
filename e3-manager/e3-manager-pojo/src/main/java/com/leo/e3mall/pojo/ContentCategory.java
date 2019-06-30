package com.leo.e3mall.pojo;
// Generated 2019-1-2 13:32:37 by Hibernate Tools 5.3.0.Beta2

import java.util.Date;

/**
 * TbContentCategory generated by hbm2java
 * 内容分类
 */
public class ContentCategory implements java.io.Serializable {

	private Long id;
	private Long parentId;//父标签id
	private String name;//名称
	private Integer status;//状态
	private Integer sortOrder;//分类id
	private Boolean isParent;//是否为父标签
	private Date created;//创建时间
	private Date updated;

	public ContentCategory() {
	}

	public ContentCategory(Long parentId, String name, Integer status, Integer sortOrder, Boolean isParent,
			Date created, Date updated) {
		this.parentId = parentId;
		this.name = name;
		this.status = status;
		this.sortOrder = sortOrder;
		this.isParent = isParent;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
