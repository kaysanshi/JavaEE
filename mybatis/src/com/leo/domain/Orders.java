package com.leo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author leoi555
 *
 */
public class Orders implements Serializable{
	 	private Integer id;
	    private Integer userId;
	    private String number;
	    private Date createtime;
	    private String note;
	    
	    //一个订单对应一个用户
	    private User user;
	    
	    
		/**
		 * @return the user
		 */
		public User getUser() {
			return user;
		}
		/**
		 * @param user the user to set
		 */
		public void setUser(User user) {
			this.user = user;
		}
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the userId
		 */
		public Integer getUserId() {
			return userId;
		}
		/**
		 * @param userId the userId to set
		 */
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		/**
		 * @return the number
		 */
		public String getNumber() {
			return number;
		}
		/**
		 * @param number the number to set
		 */
		public void setNumber(String number) {
			this.number = number;
		}
		/**
		 * @return the createtime
		 */
		public Date getCreatetime() {
			return createtime;
		}
		/**
		 * @param createtime the createtime to set
		 */
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
		/**
		 * @return the note
		 */
		public String getNote() {
			return note;
		}
		/**
		 * @param note the note to set
		 */
		public void setNote(String note) {
			this.note = note;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Orders [id=" + id + ", userId=" + userId + ", number=" + number + ", createtime=" + createtime
					+ ", note=" + note + "]";
		}
		
}
