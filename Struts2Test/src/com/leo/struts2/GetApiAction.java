package com.leo.struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 获得原生的servletApi;
 * @author leoi555
 *
 */
public class GetApiAction extends ActionSupport{
	/**
	 * ActionContext获取一切得request,response，servletContext对象，application
	 * attr域，session域，等Map类型
	 */
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//actionContext推荐使用代替map
		ActionContext context=ActionContext.getContext();
		Map<String, Object> sessionScope=ActionContext.getContext().getSession();
		//不推荐使用request域包装 
		Map<String, Object> requestScope=(Map<String, Object>) context.get("request");
			
		Map<String , Object> responseScope=(Map<String, Object>) context.get("response");
		//用于获取页面域
		Map<String , Object> applicationScope=context.getApplication();
		//这个是
		Map<String, Object> servletContext=(Map<String, Object>) context.get("ServletContext");
		
		requestScope.put("name","123");
		applicationScope.put("name", "124");
		sessionScope.put("name", "1333");
		return "success";
	}
 		
}
