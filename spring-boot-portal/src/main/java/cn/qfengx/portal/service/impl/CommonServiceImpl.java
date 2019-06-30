package cn.qfengx.portal.service.impl;

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

import cn.qfengx.portal.configuration.UploadConfig;
import cn.qfengx.portal.service.CommonService;

@Transactional
@Service("CommonServiceImpl")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private UploadConfig uploadConfig;
	
	@Override
	public Map<String, Object> img(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
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
			list.add("/pimg/" + savename);
			res.put("data", list);
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
