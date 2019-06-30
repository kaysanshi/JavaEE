package com.leo.e3mall.common.pojo;

import java.io.Serializable;

import java.util.List;
/**
 * 
 * @author leoill
 *TODO
 *2019年1月27日
 */
public class SearchResult  implements Serializable{

		private long recordCount;
		private int totalPages;
		private List<SearchItem> itemList;
		/**
		 * @return the recordCount
		 */
		public long getRecordCount() {
			return recordCount;
		}
		/**
		 * @param recordCount the recordCount to set
		 */
		public void setRecordCount(long recordCount) {
			this.recordCount = recordCount;
		}
		/**
		 * @return the totalPages
		 */
		public int getTotalPages() {
			return totalPages;
		}
		/**
		 * @param totalPages the totalPages to set
		 */
		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}
		/**
		 * @return the itemList
		 */
		public List<SearchItem> getItemList() {
			return itemList;
		}
		/**
		 * @param itemList the itemList to set
		 */
		public void setItemList(List<SearchItem> itemList) {
			this.itemList = itemList;
		}
}
