package com.leo.crm.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.leo.crm.domain.BaseDict;
import com.leo.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
/**
 * 获得枚举象
 * @author leoi555
 *
 */
public class BaseDictAction extends ActionSupport {
	private String dict_type_code;
	private BaseDictService baseDictService;
	public BaseDictService getBaseDictService() {
		return baseDictService;
	}
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//1.调用service
		List<BaseDict> list=baseDictService.getListByTypeCode(dict_type_code);
		//2,.将list转为json
		String json=JSONArray.fromObject(list).toString();
		//将json发给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;//告诉struts不需要处理
	}
	
	
}
