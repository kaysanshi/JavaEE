package com.leo.bos.domain;
// Generated 2018-10-9 18:00:39 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 工作单
 * QpWorkordermanage generated by hbm2java
 */
@Entity
@Table(name = "qp_workordermanage", catalog = "bos")
public class QpWorkordermanage implements java.io.Serializable {

	private String id;//工作单号
	private String arrivecity;//到达地
	private String product;//产品
	private Integer num;//件数
	private Double weight;//重量
	private String floadreqr;//配载要求
	private String prodtimelimit;//产品时限
	private String prodtype;//产品类型
	private String sendername;//寄件人
	private String senderphone;//寄件人地址
	private String senderaddr;//寄件
	private String receivername;//收件人
	private String receiverphone;//
	private String receiveraddr;
	private Integer feeitemnum;//计费件数
	private Double actlweit;//实际重量
	private String vol;//体积
	private String managerCheck;//是否审核配送
	private Date updatetime;//更新时间

	public QpWorkordermanage() {
	}

	public QpWorkordermanage(String id) {
		this.id = id;
	}

	public QpWorkordermanage(String id, String arrivecity, String product, Integer num, Double weight, String floadreqr,
			String prodtimelimit, String prodtype, String sendername, String senderphone, String senderaddr,
			String receivername, String receiverphone, String receiveraddr, Integer feeitemnum, Double actlweit,
			String vol, String managerCheck, Date updatetime) {
		this.id = id;
		this.arrivecity = arrivecity;
		this.product = product;
		this.num = num;
		this.weight = weight;
		this.floadreqr = floadreqr;
		this.prodtimelimit = prodtimelimit;
		this.prodtype = prodtype;
		this.sendername = sendername;
		this.senderphone = senderphone;
		this.senderaddr = senderaddr;
		this.receivername = receivername;
		this.receiverphone = receiverphone;
		this.receiveraddr = receiveraddr;
		this.feeitemnum = feeitemnum;
		this.actlweit = actlweit;
		this.vol = vol;
		this.managerCheck = managerCheck;
		this.updatetime = updatetime;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Column(name = "floadreqr")
	public String getFloadreqr() {
		return this.floadreqr;
	}

	public void setFloadreqr(String floadreqr) {
		this.floadreqr = floadreqr;
	}

	@Column(name = "prodtimelimit", length = 40)
	public String getProdtimelimit() {
		return this.prodtimelimit;
	}

	public void setProdtimelimit(String prodtimelimit) {
		this.prodtimelimit = prodtimelimit;
	}

	@Column(name = "prodtype", length = 40)
	public String getProdtype() {
		return this.prodtype;
	}

	public void setProdtype(String prodtype) {
		this.prodtype = prodtype;
	}

	@Column(name = "sendername", length = 20)
	public String getSendername() {
		return this.sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	@Column(name = "senderphone", length = 20)
	public String getSenderphone() {
		return this.senderphone;
	}

	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}

	@Column(name = "senderaddr", length = 200)
	public String getSenderaddr() {
		return this.senderaddr;
	}

	public void setSenderaddr(String senderaddr) {
		this.senderaddr = senderaddr;
	}

	@Column(name = "receivername", length = 20)
	public String getReceivername() {
		return this.receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	@Column(name = "receiverphone", length = 20)
	public String getReceiverphone() {
		return this.receiverphone;
	}

	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	@Column(name = "receiveraddr", length = 200)
	public String getReceiveraddr() {
		return this.receiveraddr;
	}

	public void setReceiveraddr(String receiveraddr) {
		this.receiveraddr = receiveraddr;
	}

	@Column(name = "feeitemnum")
	public Integer getFeeitemnum() {
		return this.feeitemnum;
	}

	public void setFeeitemnum(Integer feeitemnum) {
		this.feeitemnum = feeitemnum;
	}

	@Column(name = "actlweit", precision = 22, scale = 0)
	public Double getActlweit() {
		return this.actlweit;
	}

	public void setActlweit(Double actlweit) {
		this.actlweit = actlweit;
	}

	@Column(name = "vol", length = 20)
	public String getVol() {
		return this.vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	@Column(name = "managerCheck", length = 1)
	public String getManagerCheck() {
		return this.managerCheck;
	}

	public void setManagerCheck(String managerCheck) {
		this.managerCheck = managerCheck;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updatetime", length = 10)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}
