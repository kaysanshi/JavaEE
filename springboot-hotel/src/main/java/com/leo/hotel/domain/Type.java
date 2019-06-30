package com.leo.hotel.domain;
// Generated 2018-11-14 13:00:41 by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Type generated by hbm2java
 * 类型
 */
@Entity
@Table(name = "type", catalog = "hotel")
public class Type implements java.io.Serializable {

	private int id;
	private String typename;//类型名
	private String description;//描述
	private String remark;//备注
	private Set<Merchant> merchants = new HashSet<Merchant>(0);//一对多

	public Type() {
	}

	public Type(int id) {
		this.id = id;
	}

	public Type(int id, String typename, String description, String remark, Set<Merchant> merchants) {
		this.id = id;
		this.typename = typename;
		this.description = description;
		this.remark = remark;
		this.merchants = merchants;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "typename")
	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	public Set<Merchant> getMerchants() {
		return this.merchants;
	}

	public void setMerchants(Set<Merchant> merchants) {
		this.merchants = merchants;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Type [id=" + id + ", typename=" + typename + ", description=" + description + ", remark=" + remark
				+ ", merchants=" + merchants + "]";
	}

}
