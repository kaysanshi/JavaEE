package com.leo.crm.web.action;

import com.leo.crm.domain.LinkMan;
import com.leo.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkMan;
	private LinkManService linkManService;
	public LinkMan getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(LinkMan linkMan) {
		this.linkMan = linkMan;
	}
	public LinkManService getLinkManService() {
		return linkManService;
	}
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}

}
