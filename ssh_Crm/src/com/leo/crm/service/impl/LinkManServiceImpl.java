package com.leo.crm.service.impl;

import com.leo.crm.dao.LinkManDao;
import com.leo.crm.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao linkManDao;

	public LinkManDao getLinkManDao() {
		return linkManDao;
	}

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
}
