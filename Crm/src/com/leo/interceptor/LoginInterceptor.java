package com.leo.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 拦截器
 * @author leoi555
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		//1.获得session
				Map<String, Object> session = ActionContext.getContext().getSession();
				//2.获得登陆标识
				Object object = session.get("user");
				//3.判断登陆标识是否存在
				if(object == null){
					//不存在=>没登录=>重定向到登录页面
					return "toLogin";
				}else{
					//存在=>已经登陆=>放行
					return arg0.invoke();
				}
				
			}
	
}
