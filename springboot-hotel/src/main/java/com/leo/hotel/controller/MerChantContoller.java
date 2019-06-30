package com.leo.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.domain.Merchant;
import com.leo.hotel.domain.User;
import com.leo.hotel.service.MerchantService;
import com.leo.hotel.utils.JavaToJSon;
import com.leo.hotel.utils.PageBean;

/**
 * 商家操作
 * 商家的信息
 * @author leoill
 *TODO
 *2018年11月28日
 */
@Controller
@RequestMapping("/mc")
public class MerChantContoller {
	@Autowired
	@Qualifier("MerchantServiceImpl")
	private MerchantService merchantService;
	@Autowired
	private PageBean pageBean;
	/**
	 * login
	 * @param merchant
	 * @param request
	 * @param response
	 * @return
	 */
	public Map<String, Object> login(Merchant merchant,HttpServletRequest request,HttpServletResponse response){
		return merchantService.checkMerchant(merchant,request,response);
		
	}
	/**
	 * 通过获ajax获得的商家的hotelname
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/hotebyajax")
	@ResponseBody
	public  Map<String, Object> getHotelByAjax(@RequestParam("regionid")String regionid,HttpServletRequest request ,HttpServletResponse response){
		return merchantService.getHotelName(regionid,request,response);	
	}
	/**
	 * 修改商家信息
	 * @param user
	 * @param file
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> UpdateMerchant(Merchant merchant,@RequestParam(value="file") MultipartFile[] file,HttpServletRequest req,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (merchant.getUsername()!=null &&merchant.getPassword()!=null){
		return merchantService.updatemerChant(merchant,file,response,req);
			
		}else {
			map.put("code", "1");
			map.put("msg", "信息不全");
			map.put("data", null);
			return map;
		}	
	}
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Merchant merchant, @RequestParam(value="file")MultipartFile[] files,HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("j:"+files);
		return 	merchantService.addMerChant(merchant,files,request,response);	
	}
	/**
	 * 获取分页列表
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	@ResponseBody
	public void list(@RequestParam(name="page", required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,HttpServletRequest request
			,HttpServletResponse response) {
			Map<String, Object> map=new HashMap<>();
			//设置当前页
			pageBean.setCurrentPage(page);
			//设置页大小
			pageBean.setPageSize(rows);
			System.out.println("当前页："+page);
			System.out.println("显示的行数："+rows);
			map=merchantService.getList(page,rows,pageBean);
			System.out.println("列表zzz："+map.get("rows"));
			JavaToJSon.ResponseToJson(response, map);
	}
	
}
