package com.leo.e3mall.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.json.JSON;
import com.leo.e3mall.utils.FastDFSClient;
import com.leo.e3mall.utils.JsonUtils;

/**
 * 图片上传的
 * @author leoill
 *TODO
 *2019年1月6日
 */
@Controller
public class PictureController {
	
	@Value("IMAGE_SERVER")
	private String IMAGE_URL;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile){
		//返回String对象时直接返回的是contentType="text/plain"
		//把图片上传到服务器
		try {
			FastDFSClient fastDFSClient=new FastDFSClient("classpath:conf/client.conf");
			//取出扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			//originalFilename.substring(originalFilename.lastIndexOf(".")+1)
			//返回一个图片的地址和文件名
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), originalFilename.substring(originalFilename.lastIndexOf(".")+1));
			//补充完整的URL
			url=IMAGE_URL+url;
			//封装到map
			Map<String, Object> map=new HashMap<>();
			map.put("error", 0);
			map.put("url", url);
			return JsonUtils.objectToJson(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, Object> map=new HashMap<>();
			map.put("error", 1);
			map.put("message", "图片上传失败");
			return JsonUtils.objectToJson(map);
		}
		
	
		
	}
}
