package com.leo.course.scheduling.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

import com.leo.course.scheduling.configration.UploadConfig;
import com.leo.course.scheduling.service.CommonService;
/**
 * 公共接口
 * @author kay三石
 *TODO
 *2019年3月3日-下午12:37:55
 */
@Service("CommonServiceImpl")
@Transactional
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UploadConfig uploadConfig;

	@Override
	public Map<String, Object> img(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		try {
			//保存文件名
			String savename = UUID.randomUUID().toString().replaceAll("-", "") + new Date().getTime();
			savename += file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			
			if (file.isEmpty()) {
				throw new RuntimeException("文件不能为空");
			}
			File dest = new File(uploadConfig.getPimgPath() + savename);
			
			if (!dest.getParentFile().exists()) { 
				dest.getParentFile().mkdirs();
			}
			
			file.transferTo(dest);
			System.out.println("上传成功:" + uploadConfig.getPimgPath() + savename);
			res.put("errno", "0");//wangEditor
			res.put("code", "0");//layui
			List<String> list = new ArrayList<>();
			list.add("/images/" + savename);
			res.put("data", list);//
			//layui中需要返回的
			Map<String, Object> map=new HashMap<>();
			map.put("src", "/images/"+savename);
			map.put("title", savename);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
}
