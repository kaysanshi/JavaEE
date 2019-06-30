package com.leo.hotel.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.leo.hotel.config.UploadConfig;
import com.leo.hotel.domain.Merchant;
import com.leo.hotel.domain.Type;
import com.leo.hotel.domain.User;
import com.leo.hotel.mapper.MerchantMapper;
import com.leo.hotel.service.MerchantService;
import com.leo.hotel.utils.MD5Utils;
import com.leo.hotel.utils.PageBean;
/**
 * 商家service
 * @author leoill
 *TODO
 *2018年11月28日
 */
@Service("MerchantServiceImpl")
@Transactional
public class MerchantServiceImpl implements MerchantService{
	
	@Autowired
	private MerchantMapper mmpper;
	@Autowired
	private UploadConfig uploadConfig;
	@Override
	public Map<String, Object> addMerChant(Merchant merchant, MultipartFile[] files, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object>	 map=new HashMap<>();
		
		System.out.println("上传的路径："+uploadConfig.getPimgPath());
		if (uploadConfig.getPimgPath().isEmpty()) {
			map.put("msg", "未能指定文件");
			map.put("code", "1");
			map.put("data", null);
			return map;
		}
		int count=0;
		for(int i=0;i<files.length;i++) {
			if (!files[i].isEmpty()) {
				// 使用UUID确保上传文件不重复
				File file=new File(uploadConfig.getPimgPath() + UUID.randomUUID() + "-" +files[i].getOriginalFilename());
				if (!file.getParentFile().exists()){
					file.mkdirs();
				}
				BufferedOutputStream out;
				try {
					out = new BufferedOutputStream(
							new FileOutputStream(file));
					out.write(files[i].getBytes()); 
					out.flush();
					out.close();
					count++;
					merchant.setIcpicture("/imgs/"+ UUID.randomUUID() + "-" +files[0].getOriginalFilename()+","+"/imgs/" + UUID.randomUUID() + "-" +files[1].getOriginalFilename());
					merchant.setPicture("/imgs/" + UUID.randomUUID() + "-" +files[2].getOriginalFilename());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("文件未找到");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		if (count==0) {
			map.put("msg", "文件为空");
			map.put("code", "1");
			map.put("data", null);
			return map;
		}
		merchant.setPassword(MD5Utils.md5(merchant.getPassword()));
		int stats=mmpper.addMerChant(merchant);
		if (stats>0) {
			map.put("msg", "保存成功");
			map.put("code", "0");
			map.put("data", null);
			return map;
		}else {
			map.put("msg", "保存失败");
			map.put("code", "1");
			map.put("data", null);
			return map;
		}
	}
	@Override
	public Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean) {
		// TODO Auto-generated method stub
		//设置开始当前页
		pageBean.setCurrentPage((page-1)*rows);
		//设置每页页大小
		pageBean.setPageSize(rows);
		//查询总的记录数
		int totalCount=mmpper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		List<Merchant> listdata=mmpper.getPageQueryList(pageBean);
		pageBean.setRows(listdata);
		System.out.println("数据"+listdata);
		Map<String, Object> map=new HashMap<>();
		if (!listdata.isEmpty()) {
				map.put("total", pageBean.getTotal());
				map.put("rows", pageBean.getRows());
				return map;
			}else {
				map.put("msg", "获取失败");
				map.put("code", "0");
				map.put("data", null);
				return map;
			}
	}
	@Override
	public Map<String, Object> updatemerChant(Merchant merchant, MultipartFile[] file, HttpServletResponse response,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		Map<String, Object>	 map=new HashMap<>();
		
		System.out.println("上传的路径："+uploadConfig.getPimgPath());
		if (uploadConfig.getPimgPath().isEmpty()) {
			map.put("msg", "未能指定文件");
			map.put("code", "1");
			map.put("data", null);
			return map;
		}
		int count=0;
		for(int i=0;i<file.length;i++) {
			if (!file[i].isEmpty()) {
				// 使用UUID确保上传文件不重复
				File files=new File(uploadConfig.getPimgPath() + UUID.randomUUID() + "-" +file[i].getOriginalFilename());
				if (!files.getParentFile().exists()){
					files.mkdirs();
				}
				BufferedOutputStream out;
				try {
					out = new BufferedOutputStream(
							new FileOutputStream(files));
					out.write(file[i].getBytes()); 
					out.flush();
					out.close();
					count++;
					merchant.setIcpicture("/imgs/"+ UUID.randomUUID() + "-" +file[0].getOriginalFilename()+","+"/imgs/"+ UUID.randomUUID() + "-" +file[1].getOriginalFilename());
					merchant.setPicture("/imgs/"+ UUID.randomUUID() + "-" +file[2].getOriginalFilename());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("文件未找到");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		if (count==0) {
			map.put("msg", "文件为空");
			map.put("code", "1");
			map.put("data", null);
			return map;
		}
		merchant.setPassword(MD5Utils.md5(merchant.getPassword()));
		int stats=mmpper.updateMerChant(merchant);
		if (stats>0) {
			map.put("msg", "保存成功");
			map.put("code", "0");
			map.put("data", null);
			return map;
		}else {
			map.put("msg", "保存失败");
			map.put("code", "1");
			map.put("data", null);
			return map;
		}
	}
	@Override
	public Map<String, Object> getHotelName(String regionid,HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<>();
		List<Merchant> list=mmpper.getListByAjax(regionid);
		if (!list.isEmpty()) {
			map.put("msg", "获取成功");
			map.put("code", "0");
			map.put("data", list);
		}else {
			map.put("msg", "获取失败");
			map.put("code", "0");
			map.put("data", null);
		}
		return map;
	}
	@Override
	public Map<String, Object> checkMerchant(Merchant merchant, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		String password=MD5Utils.md5(merchant.getPassword());
		merchant.setPassword(password);
		Merchant user2 = mmpper.checkMerchant(merchant);
		if (user2!=null) {
			request.getSession().setAttribute("logionUser",user2.getUsername());
			res.put("code", "0");
			res.put("msg", "登录成功");
			res.put("data", user2);
		}else{
			res.put("code", "1");
			res.put("msg", "登录失败");
			res.put("data", null);
		}
		return res;
	}

}
