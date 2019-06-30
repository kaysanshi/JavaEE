package com.leo.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.leo.bos.domain.AuthRole;
import com.leo.bos.service.IRoleService;
import com.leo.bos.web.action.base.BaseAction;

/**
 * 角色管理
 * @author leoi555
 *
 */
@Scope("prototype")
@Controller
public class RoleAction extends BaseAction<AuthRole>{
	//属性驱动接收权限id
	private String functionIds;
	
	@Autowired
	private IRoleService roleService;
	/**
	 * @param functionIds the functionIds to set
	 */
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	 }
	/**
	 * 添加角色
	 */
	public String add() {
		roleService.add(model,functionIds);
		return "list";
	}
	/**
	 * 分页查询
	 * @return
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException {
		roleService.pageQuery(pageBean);
		this.javaToJson(pageBean, new String[]{"authFunctions","TUsers"});
		return NONE;
	}
	/**
	 * 查询所有的角色
	 * @throws IOException 
	 */
	public String listajax() throws IOException {
		List<AuthRole> list=roleService.listRole();
		this.javaToJson(list, new String[] {"authFunctions","TUsers"});
		return NONE;
		
	}
}
