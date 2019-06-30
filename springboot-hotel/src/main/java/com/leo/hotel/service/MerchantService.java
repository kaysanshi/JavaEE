package com.leo.hotel.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.domain.Merchant;
import com.leo.hotel.utils.PageBean;
/**
 * 
 * @author leoill
 *TODO
 *2018年11月28日
 */
public interface MerchantService {

	/**
	 * 商家注册
	 * @param merchant
	 * @param files
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> addMerChant(Merchant merchant, MultipartFile[] files, HttpServletRequest request,
			HttpServletResponse response);
	/**
	 * 商家类表
	 * @param page
	 * @param rows
	 * @param pageBean
	 * @return
	 */
	Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean);
	/**
	 * 商家修改
	 * @param merchant
	 * @param file
	 * @param response
	 * @param req
	 * @return
	 */
	Map<String, Object> updatemerChant(Merchant merchant, MultipartFile[] file, HttpServletResponse response,
			HttpServletRequest req);
	/**
	 * 获得商家的name
	 * @param regionid 
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> getHotelName(String regionid, HttpServletRequest request, HttpServletResponse response);
	/**
	 * login
	 * @param merchant
	 * @param request
	 * @param response
	 * @return
	 */
	Map<String, Object> checkMerchant(Merchant merchant, HttpServletRequest request, HttpServletResponse response);

}
