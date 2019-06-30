package com.leo.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.leo.springmvc.service.ItemService;
import com.leo.springmvc.domain.Items;
import com.leo.springmvc.domain.QueryVo;
/**
 * 商品管理
 * 
 * @author 
 *
 */
//配置控制器
@Controller
public class ItemController {
	/**
	 * 1.ModelAndView  无敌的    带着数据  返回视图路径           不建议使用
	 * 2.String    返回视图路径     model带数据      官方推荐此种方式   解耦   数据  视图  分离  MVC  建议使用  
	 * 3.void       ajax  请求   合适   json格式数据 （response   异步请求使用
	 * @return
	 */
	@Resource(name="itemService")
	private ItemService itemService;
	/**
	 * @return the itemService
	 */
	public ItemService getItemService() {
		return itemService;
	}
	/**
	 * @param itemService the itemService to set
	 */
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	/**
	 * 配置映射的访问路径
	 * @return
	 */
	@RequestMapping(value="/item/itemlist")
	public String itemList(Model model) {
		//从数据库中拿到数据
		System.out.println("111");
		List<Items> itemsList = itemService.getItemsList();
		//添加数据
		model.addAttribute("itemList", itemsList);
		return "itemList";
	}
	/**
	 * 修改，要传入形参绑定形参、
	 * 或者在不通过request获得直接使用指定前台请求过来的参数类型和参数名要相同
	 public ModelAndView toEdit(Integer id,HttpServletRequest request,HttpServletResponse response,
				HttpSession session,Model model){
	用标签绑定,这是你前台传过来的参数与你这里的方法的参数名不相同时用标签的方法绑定
	public ModelAndView toEdit(@RequestParam(value="id",required=false,defaultValue="1") Integer ids,HttpServletRequest request,HttpServletResponse response,
				HttpSession session,Model model){
	*/
	@RequestMapping(value="/item/toEdit")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,Model model){
		//获得参数
		String idInteger=request.getParameter("id");
		Items items=itemService.getItemById(idInteger);
		ModelAndView mav=new ModelAndView();
		//添加数据
		mav.addObject("item", items);
		//要显示的视图
		mav.setViewName("editItem");
		return mav;
		
	} 
	/**
	 * 提交修改，参数绑定为对象类型的，前台name属性与你的pojo类的字段必须相同updateitem.action
	 * 与形参没用任何关系
	 */
	@RequestMapping(value="/item/updateitem.action")
	public ModelAndView updateItems(Items items){
		//修改
		itemService.updateItemById(items);
		ModelAndView mav=new ModelAndView();
		//要显示的视图
		mav.setViewName("success");
		return mav;
		
	} 
	/**
	 * 修改使用包装类pojo
	 * @param vo
	 * @return
	 */
	public ModelAndView updateitembyQ(QueryVo vo){

		//修改
		itemService.updateItemsByIdByQ(vo.getItems());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
		
	}
	/**
	 * 在使用list，array时必须使用包装类如果不适用包装不能解析
	 * spring 未提供这些的方法
	 * @param vo
	 * @return
	 */
	//删除多个数组的
		@RequestMapping(value = "/deletes.action")
		public ModelAndView deletes(QueryVo vo){
			
			itemService.deleteItemsByIdByQbyArray(vo.getIds());
			ModelAndView mav = new ModelAndView();
			mav.setViewName("success");
			return mav;
		}
		//修改
		@RequestMapping(value = "/updates.action",method = {RequestMethod.POST,RequestMethod.GET})
		public ModelAndView updates(QueryVo vo){
			
			//修改
			itemService.updateItemsByIdByQList(vo.getItemsList());
			ModelAndView mav = new ModelAndView();
			mav.setViewName("success");
			return mav;
		}

		/**
		 * 登录
		 * @return
		 */
		@RequestMapping(value = "/login.action",method = RequestMethod.GET)
		public String login(){
			return "login";
		}
		@RequestMapping(value = "/login.action",method = RequestMethod.POST)
		public String login(String username
				,HttpSession httpSession){
			httpSession.setAttribute("USER_SESSION", username);
			return "redirect:/item/itemlist.action";
		}
}
