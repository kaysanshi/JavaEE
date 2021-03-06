package com.leo.bos.domain;
// Generated 2018-10-9 18:00:39 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 定区
 * BcDecidedzone generated by hbm2java
 */
@Entity
@Table(name = "bc_decidedzone", catalog = "bos")
public class BcDecidedzone implements java.io.Serializable {

	private String id;
	//多对一
	private BcStaff bcStaff;//取派员id
	private String name;
	//一对多:定区可以有好多分区
	private Set<BcSubarea> bcSubareas = new HashSet<BcSubarea>(0);

	public BcDecidedzone() {
	}

	public BcDecidedzone(String id) {
		this.id = id;
	}

	public BcDecidedzone(String id, BcStaff bcStaff, String name, Set<BcSubarea> bcSubareas) {
		this.id = id;
		this.bcStaff = bcStaff;
		this.name = name;
		this.bcSubareas = bcSubareas;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	public BcStaff getBcStaff() {
		return this.bcStaff;
	}

	public void setBcStaff(BcStaff bcStaff) {
		this.bcStaff = bcStaff;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bcDecidedzone")
	public Set<BcSubarea> getBcSubareas() {
		return this.bcSubareas;
	}

	public void setBcSubareas(Set<BcSubarea> bcSubareas) {
		this.bcSubareas = bcSubareas;
	}

}
