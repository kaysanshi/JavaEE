package com.leo.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 继承抽象的
 * @author leoi555
 *
 */
public class MyInterceptor1 extends AbstractInterceptor{
	/**
	 * 实现过滤器方法只用来实现
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
