package com.leo.bos.web.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.leo.bos.domain.QpWorkordermanage;
import com.leo.bos.service.IWorkOrderManageService;
import com.leo.bos.web.action.base.BaseAction;
/**
 * 加注解其实是创建了一个代理对象；这里的这些都是使用的代理对象
 * @author leoi555
 *
 */
@Controller
@Scope(value="prototype")
public class WorkordermanageAction extends BaseAction<QpWorkordermanage> {
	@Autowired
	private IWorkOrderManageService workOrderManagerService;
	/**
	 * 添加
	 * @throws IOException 
	 */
	public String  add() throws IOException {
		String fString="1";
		try {
			workOrderManagerService.save(model);
		} catch (Exception e) {
			// TODO: handle exception
			fString="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(fString);
		return NONE;
	}
}
