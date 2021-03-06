package com.leo.hotel.domain;
// Generated 2018-11-14 13:00:41 by Hibernate Tools 5.0.6.Final

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

import org.thymeleaf.model.IOpenElementTag;

/**
 * Merchant generated by hbm2java
 * 商家表
 */
@Entity
@Table(name = "merchant", catalog = "hotel")
public class Merchant implements java.io.Serializable {
	private int id;
	private String username;//用户名
	private String password;
	private String gender;
	private String telephone;//手机号
	private String email;//email
	private String icpicture;//省份证图片
	private String telephonecode;//验证码
	private String name;//酒店名
	private String phone;//电话
	private Region region;//区域
	private String adress;//地址
	private Type type;//类型
	private Starlevel starlevel;//星级
	private String pricesStart;//价格区间
	private String pricesEnd;
	private String roomCount;//房间数
	private String description;//酒店描述
	private String picture;//大厅图片
	private Set<Room> rooms = new HashSet<Room>(0);//一个商家多个房间

	
	private Integer typeid;
	
	private String  regionid;
	
	private Integer starid;
	
	private String regionName;
	private String typeName;
	private String starName;
	
	
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the starName
	 */
	public String getStarName() {
		return starName;
	}

	/**
	 * @param starName the starName to set
	 */
	public void setStarName(String starName) {
		this.starName = starName;
	}

	/**
	 * @return the starid
	 */
	
	public Integer getStarid() {
		return starid;
	}

	/**
	 * @param starid the starid to set
	 */
	public void setStarid(Integer starid) {
		this.starid = starid;
	}

	/**
	 * @return the regionid
	 */
	public String getRegionid() {
		return regionid;
	}

	/**
	 * @param regionid the regionid to set
	 */
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}

	/**
	 * @return the typeid
	 */
	
	public Integer getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Merchant() {
	}

	public Merchant(int id) {
		this.id = id;
	}
	
	
	

	public Merchant(int id, String username, String password, String gender, String telephone, String email,
			String icpicture, String telephonecode, String name, String phone, Region region, String adress, Type type,
			Starlevel starlevel, String pricesStart, String pricesEnd, String roomCount, String description,
			String picture, Set<Room> rooms, Integer typeid, String regionid, Integer starid, String regionName,
			String typeName, String starName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.telephone = telephone;
		this.email = email;
		this.icpicture = icpicture;
		this.telephonecode = telephonecode;
		this.name = name;
		this.phone = phone;
		this.region = region;
		this.adress = adress;
		this.type = type;
		this.starlevel = starlevel;
		this.pricesStart = pricesStart;
		this.pricesEnd = pricesEnd;
		this.roomCount = roomCount;
		this.description = description;
		this.picture = picture;
		this.rooms = rooms;
		this.typeid = typeid;
		this.regionid = regionid;
		this.starid = starid;
		this.regionName = regionName;
		this.typeName = typeName;
		this.starName = starName;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "star_level")
	public Starlevel getStarlevel() {
		return this.starlevel;
	}

	public void setStarlevel(Starlevel starlevel) {
		this.starlevel = starlevel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type")
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "adress")
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "prices_start")
	public String getPricesStart() {
		return this.pricesStart;
	}

	public void setPricesStart(String pricesStart) {
		this.pricesStart = pricesStart;
	}

	@Column(name = "prices_end")
	public String getPricesEnd() {
		return this.pricesEnd;
	}

	public void setPricesEnd(String pricesEnd) {
		this.pricesEnd = pricesEnd;
	}

	@Column(name = "room_count")
	public String getRoomCount() {
		return this.roomCount;
	}

	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "picture")
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "icpicture")
	public String getIcpicture() {
		return this.icpicture;
	}

	public void setIcpicture(String icpicture) {
		this.icpicture = icpicture;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "telephonecode")
	public String getTelephonecode() {
		return this.telephonecode;
	}

	public void setTelephonecode(String telephonecode) {
		this.telephonecode = telephonecode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", telephone=" + telephone + ", email=" + email + ", icpicture=" + icpicture + ", telephonecode="
				+ telephonecode + ", name=" + name + ", phone=" + phone + ", region=" + region + ", adress=" + adress
				+ ", type=" + type + ", starlevel=" + starlevel + ", pricesStart=" + pricesStart + ", pricesEnd="
				+ pricesEnd + ", roomCount=" + roomCount + ", description=" + description + ", picture=" + picture
				+ ", rooms=" + rooms + ", typeid=" + typeid + ", regionid=" + regionid + ", starid=" + starid
				+ ", regionName=" + regionName + ", typeName=" + typeName + ", starName=" + starName + "]";
	}
	
	

	



	

	
	
}
