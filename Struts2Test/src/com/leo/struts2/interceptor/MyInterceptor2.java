package com.leo.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 最常用的拦截器
 * @author leoi555
 *定制拦截器拦截的方法，
 *定制哪些方法需要拦截
 *哪些方法不需要拦截
 */
public class MyInterceptor2  extends MethodFilterInterceptor{
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//前处理
			System.out.println("前处理");
		//放行
			invocation.invoke();
		//后续
			System.out.println("后处理");
			return "success";
	}

}
