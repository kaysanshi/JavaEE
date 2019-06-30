package com.leo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * pojo：java普通对象
 * @author leoi555
 *
 */
public class User implements Serializable{
		private int id;
		private String username;
		private Date birthday;
		private String sex;
		private String address;
		/**
		 * 一对多
		 */
		private List<Orders> orders;
		/**
		 * @return the orders
		 */
		public List<Orders> getOrders() {
			return orders;
		}
		/**
		 * @param orders the orders to set
		 */
		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "User [id=" + id + ", username=" + username + ", sex=" + sex
					+ ", birthday=" + birthday + ", address=" + address + "]";
		}
		
		
}	
