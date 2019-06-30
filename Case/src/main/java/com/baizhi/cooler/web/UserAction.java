package com.baizhi.cooler.web;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean.StatefulMethodInvokingJob;
import org.springframework.stereotype.Controller;

import com.baizhi.cooler.domain.Admin;
import com.baizhi.cooler.service.UserService;
import com.baizhi.cooler.web.baseaction.BaseAction;
/**
 * 管理员登录
 * @author leoi555
 *
 */
@Scope(value="prototype")
public class UserAction extends BaseAction<Admin>{
	@Resource
	private UserService userService;
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		//属性驱动的注入，接收页面的验证码
		private String  checkcode;
		
		/**
		 * @return the checkcode
		 */
		public String getCheckcode() {
			return checkcode;
		}
		/**
		 * @param checkcode the checkcode to set
		 */
		public void setCheckcode(String checkcode) {
			this.checkcode = checkcode;
		}
		
		public String login() {
			//获取session域中的
			String vcode=(String) ServletActionContext.getRequest().getSession().getAttribute("key");
			//StringUtils.isBlank检测是否为"" ,null,空串
			if (checkcode.equals(vcode)&& StringUtils.isNoneBlank(checkcode)) {
				Admin user=userService.checkLogin(model);
				if (user!=null) {
					System.out.println("登录的用户的id:"+user.getId());
					//登录成功后
					 ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
					 System.out.println(ServletActionContext.getRequest().getSession().getAttribute("loginUser"));
					 return "home";
					}else {
							//登录失败
							//输入错误跳转到登录界面
							this.addActionError("用户或密码错误");
							return LOGIN;
						}
				}
			return LOGIN;	
		}
		/**
		 * 前台通过Ajax来处理
		 * @return
		 */
		public String editPassword() {
			String flag="0";
			Admin admin = (Admin) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
			try {
				System.out.println("前台传入的password:"+model.getPassword());
				userService.editPassword(admin.getId(),model.getPassword());
				flag="1";
				ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
				ServletActionContext.getResponse().getWriter().write(flag);
			} catch (Exception e) {
				// TODO: handle exception
				flag="0";
				e.printStackTrace();
			}
			return NONE;
		}
		/**
		 * 退出登录
		 * @return
		 */
		public String logout() {
			ServletActionContext.getRequest().getSession().invalidate();
			return "login";
		}
}
