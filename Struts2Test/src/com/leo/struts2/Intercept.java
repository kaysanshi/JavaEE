package com.leo.struts2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 拦截器类
 * @author leoi555
 *
 */
public class Intercept extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
			//输出前
	      String output = "Pre-Processing"; 
	      System.out.println(output);

	      //启动进程 
	      String result = arg0.invoke();

	      //输出后
	      output = "Post-Processing"; 
	      System.out.println(output);

	      return result;
	}

}
