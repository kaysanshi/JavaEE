package com.leo.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.leo.bos.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 继承父类中不使用它的接口(自定义拦截器)
 * @author leoi555
 *
 */
public class LogoinInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//获取请求路径
		ActionProxy proxy = invocation.getProxy();
		String actionName=proxy.getActionName();
		String nameSpace=proxy.getNamespace();
		String url=nameSpace+actionName;
		System.out.println(url);
		//前处理
		User session=(User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");	
		//判断session是否为null
		if(session==null) {
			return "login";
		}
		//后处理
		return invocation.invoke();
	}

}
