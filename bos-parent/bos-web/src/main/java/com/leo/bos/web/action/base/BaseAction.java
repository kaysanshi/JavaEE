package com.leo.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.leo.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 表现层的抽取
 * @author leoi555
 *
 */
public class  BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	//模型对象
	protected T model;
	//属性
	protected int page;
	protected int rows;
	protected PageBean pageBean=new PageBean();
	//创建离线查询对象
	DetachedCriteria detachedCriteria=null;
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}
	
	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	//构造方法中获得实体类的类型用过反射创建model对象
	public BaseAction() {
		//获得当前类型的父类
		ParameterizedType genericSuperclass=(ParameterizedType)this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型；获取baseAction上声明的泛型数组
		//返回值为数组类型的，最后再取出
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> clazz = (Class<T>)actualTypeArguments[0];
		System.out.println("运行时期的："+clazz);
		detachedCriteria=DetachedCriteria.forClass(clazz);
		pageBean.setDetachedCriteria(detachedCriteria);
		//通过反射创建对象：
			try {
				model=clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	//输入json---list-->json
	public void javaToJson(Object o,String[] excludes) throws IOException {
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize"});
		//jsonObjectd中的方法
		String json=JSONObject.fromObject(o,jsonConfig).toString();
		System.out.println(json);
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
	}
	

}
