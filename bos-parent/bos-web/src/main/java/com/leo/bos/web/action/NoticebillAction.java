package com.leo.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;
import com.leo.bos.domain.QpNoticebill;
import com.leo.bos.service.INoticebillService;
import com.leo.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 业务通知单
 * @author leoi555
 *
 */
@Controller
@Scope(value="prototype")
public class NoticebillAction extends BaseAction<QpNoticebill>{
	//注入crm客户端代理对象
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private INoticebillService noticebillService;
	/**
	 * 远程调用:
	 * @return
	 * @throws IOException 
	 */
	public String findCustomerByTelephone() throws IOException {
		String telephone=model.getTelephone();
		Customer customer=customerService.findCustomerByTelephone(telephone);
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[]{});
				//jsonObjectd中的方法
				String json=JSONObject.fromObject(customer).toString();
				System.out.println(json.toString());
				//写回到前台
				ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
				//print.write
				ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
	/**
	 * 添加页面
	 * @return
	 */
	public String add() {
		noticebillService.add(model);
		return "add";	
	}
	
	
}
