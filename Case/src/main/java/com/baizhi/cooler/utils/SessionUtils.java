package com.baizhi.cooler.utils;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.cooler.domain.Admin;
/**
 * 获取session的工具类
 * @author leoi555
 *
 */
public class SessionUtils {
	//获取session
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	//获取登录用户
	public static Admin getLoginUser() {
		return (Admin) getSession().getAttribute("loginUser");
	}
	
}
