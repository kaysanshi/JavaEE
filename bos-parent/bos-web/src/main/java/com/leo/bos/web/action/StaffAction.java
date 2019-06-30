package com.leo.bos.web.action;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Scanner;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leo.bos.domain.BcStaff;
import com.leo.bos.service.IStaffService;
import com.leo.bos.utils.PageBean;
import com.leo.bos.web.action.base.BaseAction;

import net.bytebuddy.asm.Advice.This;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 取派员管理
 * @author leoi555
 *
 */


@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<BcStaff> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性驱动
	private int page;
	private int rows;
	private String ids;
	 static int number=0;
	
	/**
	 * @param ids the ids to set
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}

	@Autowired
	private IStaffService staffService;
	/**
	 * 添加取派员
	 * @return
	 */
	public String add() {
		staffService.addStaff(model);
		System.out.println(model.getId());
		return "list";
		
	}
	/**
	 * 分页查询通过写回json给前台用
	 * @return
	 * @throws IOException 
	 */
	@Test
	public String  pageQuery() throws IOException {
		PageBean  pageBean=new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		//创建离线查询对象
		DetachedCriteria sCriteria=DetachedCriteria.forClass(BcStaff.class);
		pageBean.setDetachedCriteria(sCriteria);
		staffService.pageQuery(pageBean);
		//将pagebean转换为json通过输出流写会到前台
		//jsonObject---将单一的对象转为json
		//jsonArray---将数组或集合转为json
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize"});
		//jsonObjectd中的方法
		String json=JSONObject.fromObject(pageBean).toString();
		System.out.println(json.toString());
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
		
	}
	/**
	 * 批量删除
	 * @return
	 */
	//这是加入shiro的注解指定用户必须有这个权限
	//才能调用这个方法
	@RequiresPermissions("staff-delete")
	public String  deleteBatch() {
		staffService.deleteBatch(ids);
		return "list";
	}
	/**
	 * 修改
	 * 这里的更新有多表关联不能直接进行对整个model的更新，需要设置直接更新的数据
	 * @return
	 */
	public String edit() {
		/**
		 * @RequiresPermissions("staff-delete")
		 * //另一种方式：
		Subject subject = SecurityUtils.getSubject();
		subject.checkPermission("staff-edit");
		 */
		//另一种方式：
		//Subject subject = SecurityUtils.getSubject();
		//subject.checkPermission("staff-edit");
		//
		//根据id 查询原始数据
		BcStaff  staff=staffService.findById(model.getId());
		//使用页面提交的数据进行覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return "list";
	}
	/**
	 * 查询所有的未删除的取派员
	 * @throws IOException 
	 */
	
	public String list() throws IOException {
		List<BcStaff> list=staffService.findlistNotdel();
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[] {"bcDecidedzones"});
		//jsonObjectd中的方法
		String json=JSONObject.fromObject(list).toString();
		System.out.println(json.toString());
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		 StaffAction[] staffActions=new StaffAction[10];
//		 System.out.println(staffActions.length);
//		while(number<staffActions.length) {
//			Scanner scanner=new Scanner(System.in);
//			System.out.println("请输入数字");
//			String string=scanner.next();
//			String string2=scanner.next();
//			
//			int  ll=scanner.nextInt();
//			System.out.println(string +","+string2+","+ll);
//			System.out.println(number);
//			staffActions[number]=new StaffAction();
//			staffActions[number].setIds(string);
//			System.out.println("huode:"+staffActions[number].getIds());
//			number++;
//			System.out.println(number);
//			
//			if (number==staffActions.length) {
//				break;
//			}
//			
//		}
//	}
	
}
