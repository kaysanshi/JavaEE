package com.news.entity;

import java.util.Date;

public class NewsQueue {
	private String newsId;//����id
	private String newsTitle;//���ű���
	private Date newsUpdateTime;//�ύʱ��
	private double newsTimeWeight;//����ʱ��Ȩ��
	public String getNewsId() {
		return newsId;
	}
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public double getNewsTimeWeight() {
		return newsTimeWeight;
	}
	public void setNewsTimeWeight(double newsTimeWeight) {
		this.newsTimeWeight = newsTimeWeight;
	}
	public Date getNewsUpdateTime() {
		return newsUpdateTime;
	}
	public void setNewsUpdateTime(Date newsUpdateTime) {
		this.newsUpdateTime = newsUpdateTime;
	}
	
}
