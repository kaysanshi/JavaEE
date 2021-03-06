package com.leo.bos.domain;
// Generated 2018-10-9 18:00:39 by Hibernate Tools 3.5.0.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 业务通知单
 * QpNoticebill generated by hbm2java
 */
@Entity
@Table(name = "qp_noticebill", catalog = "bos")
public class QpNoticebill implements java.io.Serializable {

	private String id;//业务单号
	
	private String customerId;//客户编号
	private String customerName;//客户名称
	private String delegater;//联系人
	private String telephone;//电话
	private String pickaddress;//取件地址
	private String arrivecity;//到达城市
	private String product;//产品
	private Date pickdate;//预约取件时间
	private Integer num;//件数
	private Double weight;//重量
	private String volume;//体积
	private String remark;//备注
	private String ordertype;//分单类型：自动，人工
	public static final String ORDETYPE_AUTO="自动分单";
	public static final String ORDETYPE_MAN="人工分单";
	//一对多
	private User User; //受理人
	private BcStaff bcStaff;//取派员
	//多对一
	private Set<QpWorkbill> qpWorkbills = new HashSet<QpWorkbill>(0);

	public QpNoticebill() {
	}

	public QpNoticebill(String id) {
		this.id = id;
	}

	public QpNoticebill(String id, User TUser, BcStaff bcStaff, String customerId, String customerName,
			String delegater, String telephone, String pickaddress, String arrivecity, String product, Date pickdate,
			Integer num, Double weight, String volume, String remark, String ordertype, Set<QpWorkbill> qpWorkbills) {
		this.id = id;
		this.User = TUser;
		this.bcStaff = bcStaff;
		this.customerId = customerId;
		this.customerName = customerName;
		this.delegater = delegater;
		this.telephone = telephone;
		this.pickaddress = pickaddress;
		this.arrivecity = arrivecity;
		this.product = product;
		this.pickdate = pickdate;
		this.num = num;
		this.weight = weight;
		this.volume = volume;
		this.remark = remark;
		this.ordertype = ordertype;
		this.qpWorkbills = qpWorkbills;
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
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.User;
	}

	public void setUser(User TUser) {
		this.User = TUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	public BcStaff getBcStaff() {
		return this.bcStaff;
	}

	public void setBcStaff(BcStaff bcStaff) {
		this.bcStaff = bcStaff;
	}

	@Column(name = "customer_id", length = 32)
	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name = "customer_name", length = 20)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "delegater", length = 20)
	public String getDelegater() {
		return this.delegater;
	}

	public void setDelegater(String delegater) {
		this.delegater = delegater;
	}

	@Column(name = "telephone", length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "pickaddress", length = 200)
	public String getPickaddress() {
		return this.pickaddress;
	}

	public void setPickaddress(String pickaddress) {
		this.pickaddress = pickaddress;
	}

	@Column(name = "arrivecity", length = 20)
	public String getArrivecity() {
		return this.arrivecity;
	}

	public void setArrivecity(String arrivecity) {
		this.arrivecity = arrivecity;
	}

	@Column(name = "product", length = 20)
	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pickdate", length = 10)
	public Date getPickdate() {
		return this.pickdate;
	}

	public void setPickdate(Date pickdate) {
		this.pickdate = pickdate;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "weight", precision = 22, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "volume", length = 20)
	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "ordertype", length = 20)
	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qpNoticebill")
	public Set<QpWorkbill> getQpWorkbills() {
		return this.qpWorkbills;
	}

	public void setQpWorkbills(Set<QpWorkbill> qpWorkbills) {
		this.qpWorkbills = qpWorkbills;
	}

}
