package com.leo.struts2.ognl;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/***
 * 对象导航语言
 * @author leoi555
 *
 */
public class OGNLAction extends ActionSupport {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		/**
		 * 访问值栈
		 */
		ValueStack stack=ActionContext.getContext().getValueStack();
		Map<String , Object> context=new HashMap<>();
		context.put("key1", new String("yuesnjnjkv"));
		context .put("key2", new String("122333"));
		//压栈
		stack.push(context);
		System.out.println(stack.size()+"大小");
		//获取Actioncontext来储存数据
		ActionContext.getContext().put("list", "12ioi");
		//前台获取数据：
		//${list};
		//<s:property value="list">
		return "success";	
	}
	
}
