package com.leo.bos.domain;
// Generated 2018-10-9 18:00:39 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 分区
 * BcSubarea generated by hbm2java
 */
@Entity
@Table(name = "bc_subarea", catalog = "bos")
public class BcSubarea implements java.io.Serializable {

	private String id;
	private BcRegion bcRegion;//区域设置主键
	private BcDecidedzone bcDecidedzone;//定区主键
	private String addresskey;//地址关键字
	private String startnum;//起始号
	private String endnum;
	private Character single;//单双号
	private String position;//位置

	public BcSubarea() {
	}

	public BcSubarea(String id) {
		this.id = id;
	}

	public BcSubarea(String id, BcRegion bcRegion, BcDecidedzone bcDecidedzone, String addresskey, String startnum,
			String endnum, Character single, String position) {
		this.id = id;
		this.bcRegion = bcRegion;
		this.bcDecidedzone = bcDecidedzone;
		this.addresskey = addresskey;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
		this.position = position;
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
	@JoinColumn(name = "region_id")
	public BcRegion getBcRegion() {
		return this.bcRegion;
	}

	public void setBcRegion(BcRegion bcRegion) {
		this.bcRegion = bcRegion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "decidedzone_id")
	public BcDecidedzone getBcDecidedzone() {
		return this.bcDecidedzone;
	}

	public void setBcDecidedzone(BcDecidedzone bcDecidedzone) {
		this.bcDecidedzone = bcDecidedzone;
	}

	@Column(name = "addresskey", length = 100)
	public String getAddresskey() {
		return this.addresskey;
	}

	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}

	@Column(name = "startnum", length = 30)
	public String getStartnum() {
		return this.startnum;
	}

	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}

	@Column(name = "endnum", length = 30)
	public String getEndnum() {
		return this.endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	@Column(name = "single", length = 1)
	public Character getSingle() {
		return this.single;
	}

	public void setSingle(Character single) {
		this.single = single;
	}

	@Column(name = "position")
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
