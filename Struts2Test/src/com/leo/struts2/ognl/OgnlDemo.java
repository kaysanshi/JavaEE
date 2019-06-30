package com.leo.struts2.ognl;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * 取出Map属性的值
 * @author leoi555
 *
 */
public class OgnlDemo extends ActionSupport {
	/**
	 * 获得根属性值
	 * @throws OgnlException
	 */
	@Test
	public void test() throws OgnlException {
		User root=new User("tom",23);
		Map<String , Object> map=new HashMap<>();
		map.put("user1", new User("jack",12));
		map.put("user2", new User("we", 20));
		OgnlContext oContext=new OgnlContext();
		//将root作为root部分
		oContext.setRoot(root);
		oContext.setValues(map);
		//书写OGNL
		//Ognl.getValue("", oContext, oContext.getRoot());
		//取出User 中对象的属性
		String name=(String)Ognl.getValue("username",oContext,oContext.getRoot());
		System.out.println(name);
	
		
		
 	}
	/**
	 * 获取根对应得栈值
	 * @throws OgnlException
	 */
	@Test
	public void test1() throws OgnlException {
		User user=new User("tom",23);
		Map<String , Object> map=new HashMap<>();
		map.put("user1", new User("jack",12));
		map.put("user2", new User("we", 20));
		OgnlContext oContext=new OgnlContext();
		oContext.setRoot(user);
		oContext.setValues(map);
		//取出context属性就是把map对象添加到里面
		//获取context对象的属性值
		String name2=(String)Ognl.getValue("#user1.username",oContext,oContext.getRoot());
		System.out.println(name2);
		int name23=(int)Ognl.getValue("#user1.age",oContext,oContext.getRoot());
		System.out.println(name23);
	}
	
	/**
	 * =赋值
	 */
	@Test
	public void test2() throws OgnlException {
		User user=new User("tom",23);
		Map<String , Object> map=new HashMap<>();
		map.put("user1", new User("jack",12));
		map.put("user2", new User("we", 20));
		OgnlContext oContext=new OgnlContext();
		oContext.setRoot(user);
		oContext.setValues(map);
		//赋值然后在取值
		String name2=(String)Ognl.getValue("#user1.username='张三'",oContext,oContext.getRoot());
		System.out.println(name2);
		int name23=(int)Ognl.getValue("#user1.age=122",oContext,oContext.getRoot());
		System.out.println(name23);
	}
	/**
	 * 调用方法：通过方法设置属性
	 * 
	 * 
	 */
	@Test
	public void test3() throws OgnlException {
		User user=new User("tom",23);
		Map<String , Object> map=new HashMap<>();
		map.put("user1", new User("jack",12));
		map.put("user2", new User("we", 20));
		OgnlContext oContext=new OgnlContext();
		oContext.setRoot(user);
		oContext.setValues(map);
		String name=(String) Ognl.getValue("getUsername()", oContext,oContext.getRoot());
		System.out.println(name);
		String name1=(String )Ognl.getValue("setUsername('nic'),getUsername()",  oContext,oContext.getRoot());
		System.out.println(name1);
		//调用静态属性
		Double pi=(Double)Ognl.getValue("@@PI", oContext,oContext.getRoot());
		System.out.println(pi);
	}
	/**
	 * 取出list map集合
	 */
	@Test
	public void test4() throws Exception{
		//准备ONGLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
		Map<String,User> context = new HashMap<String,User>();
		context.put("user1", new User("jack",18));
		context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//创建list对象
		Integer size = (Integer) Ognl.getValue("{'tom','jerry','jack','rose'}.size()", oc, oc.getRoot());
		String name = (String) Ognl.getValue("{'tom','jerry','jack','rose'}[0]", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("{'tom','jerry','jack','rose'}.get(1)", oc, oc.getRoot());
	
		System.out.println(size);
		System.out.println(name);
		System.out.println(name2);
		//创建Map对象
		Integer size2 = (Integer) Ognl.getValue("#{'name':'tom','age':18}.size()", oc, oc.getRoot());
		String name3  = (String) Ognl.getValue("#{'name':'tom','age':18}['name']", oc, oc.getRoot());
		Integer age  = (Integer) Ognl.getValue("#{'name':'tom','age':18}.get('age')", oc, oc.getRoot());
		System.out.println(size2);
		System.out.println(name3);
		System.out.println(age);
	}	
}
