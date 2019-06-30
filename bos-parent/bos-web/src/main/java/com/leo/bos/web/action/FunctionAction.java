package com.leo.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.leo.bos.domain.AuthFunction;
import com.leo.bos.service.IFunctionService;
import com.leo.bos.utils.PageBean;
import com.leo.bos.web.action.base.BaseAction;

/**
 * 权限
 * @author leoi555
 *
 */
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<AuthFunction>{
	
	@Autowired
	private IFunctionService functionService;
	
	/**
	 * 通过ajax来获取list加载权限列表
	 * @return
	 * @throws IOException 
	 */
	public String list() throws IOException {
		List<AuthFunction> list =functionService.getlist();
		this.javaToJson(list, new String[]{"authFunction","roles","authFunctions"});
		return NONE;
		
	}
	/**
	 * 添加
	 * @return
	 */
	public String add() {
		functionService.add(model);
		
		return "list";
	}
	/**
	 * 分页列表
	 * 
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException {
		/**
		 *调用page因为在Function实体类中有page属性而在pageBean中的page属性没有注入值，
		 *所以这里调用时不会翻页；
		 */
		//改变的方式
		String page=model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		functionService.pageQuery(pageBean);
		this.javaToJson(pageBean, new String[]{"authFunction","roles","authFunctions"});
		return NONE;
		
	}
	/**
	 * 加载菜单树:根据用户的权限查询
	 * @throws IOException 
	 */
	public String findMenu() throws IOException{
		List<AuthFunction> list =functionService.findMenu();
		this.javaToJson(pageBean, new String[] {"authFunction","roles","authFunctions"});
		return null;
		
	}
}
