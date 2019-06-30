package com.leo.bos.web.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.crm.ICustomerService;
import com.leo.bos.domain.AuthRole;
import com.leo.bos.domain.QpNoticebill;
import com.leo.bos.domain.User;
import com.leo.bos.service.IuserService;
import com.leo.bos.utils.MD5Utils;
import com.leo.bos.web.action.base.BaseAction;


/**
 * 
 * @author leoi555
 *
 */

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	//注入Crm代理对象
	@Autowired
	private ICustomerService customerService;
	//属性驱动的注入，接收页面的验证码
	private String  checkcode;
	private String[] roleIds;
	/**
	 * @param roleIds the roleIds to set
	 */
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	@Autowired
	private IuserService iservice;
	/**
	 * @param checkcode the checkcode to set
	 */
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	/**
	 * 
	 * @return
	 */
	//@RequestMapping("userAction_login.action")
	public String login(){
//		//测试：
//		Customer customerById = customerService.getCustomerById(1);
//		System.out.println(customerById.getCustName());
		//获取session中的验证码
		String vcode=(String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//校验验证码是否正确
		if (checkcode.equals(vcode)&& StringUtils.isNoneBlank(checkcode)) {
//			User user=iservice.login(model);
//			if (user!=null) {
////				System.out.println("登录的用户的id:"+user.getId());
////				//登录成功后
////				 ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
////				 System.out.println(ServletActionContext.getRequest().getSession().getAttribute("loginUser"));
////				 return "home";
//			
		//}else {
				//登录失败
				//输入错误跳转到登录界面
				//this.addActionError("用户或密码错误");
				//return LOGIN;
			//}
			/**
			 * 用shio提供的框方式来进行认证
			 * 
			 */
			Subject subject= SecurityUtils.getSubject();
			//创建用户令牌对象
			AuthenticationToken token=new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword()));
			try {
					//这时就会调用安全管理器
				subject.login(token);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.getStackTrace();
					return LOGIN;
				}
			User user2=(User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user2);
			return "home";
			
		}else {
			//输入错误跳转到登录界面
			this.addActionError("输入的验证码错误");
			return LOGIN;
		}
		
	}
	/***
	 * 退出登录
	 * @return
	 */
	public String logout() {
		//注销session
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	/**
	 * 修改密码：通过ajax来提交写会1时执行成功，否者返回0;
	 * @return
	 */
	public String editPassword() {
		String fString="1";
		//获取当前的用户
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		try {
			System.out.println(":::"+model.getPassword());
			iservice.editPassword(user.getId(),model.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			fString="0";
			e.printStackTrace();
		}
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(fString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	/**
	 * 添加角色，同时把他所具有的角色的权限也给添加进行
	 * 从前台获取到节点的数组的值，然后把相应的id给后台使用
	 * add
	 */
	public String add() {
		iservice.save(model,roleIds);
		return "list";	
	}
	/**
	 * 用户分页查询出用户
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException {
		iservice.pageQuery(pageBean);
		javaToJson(pageBean, new String[]{"qpNoticebill", "authRoles"});
		return NONE;
	}
}
