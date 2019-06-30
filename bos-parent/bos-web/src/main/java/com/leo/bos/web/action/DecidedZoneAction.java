package com.leo.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.leo.bos.domain.BcDecidedzone;
import com.leo.bos.domain.BcRegion;
import com.leo.bos.service.IDecidedZoneService;
import com.leo.bos.utils.PageBean;
import com.leo.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 定区action
 * @author leoi555
 *
 */
@Controller
@Scope("prototype")
public class DecidedZoneAction extends BaseAction<BcDecidedzone>{
	//属性驱动
	private String[] subareaid;

	/**
	 * @return the subareaid
	 */
	public String[] getSubareaid() {
		return subareaid;
	}

	/**
	 * @param subareaid the subareaid to set
	 */
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	@Autowired
	private IDecidedZoneService dzService;
	/**
	 * 添加定区
	 */
	public String add() {
		dzService.save(model,subareaid);
		return "list";
	}
	/**
	 * 分页查询
	 * @return
	 * @throws IOException
	 */
	public String pageQuery() throws IOException{
		PageBean  pageBean=new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		//创建离线查询对象
		DetachedCriteria sCriteria=DetachedCriteria.forClass(BcDecidedzone.class);
		pageBean.setDetachedCriteria(sCriteria);
		dzService.pageQuery(pageBean);
		//将pagebean转换为json通过输出流写会到前台
		//jsonObject---将单一的对象转为json
		//jsonArray---将数组或集合转为json
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json把关联对象的属性给排除掉，
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize","bcSubareas"," bcDecidedzones"});
		//jsonObjectd中的方法
		String json=JSONObject.fromObject(pageBean).toString();
		System.out.println(json);
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
		
		return NONE;
		
	}
}
