package com.leo.course.scheduling.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.resource.HttpResource;

import com.leo.course.scheduling.configration.UploadConfig;
import com.leo.course.scheduling.service.CommonService;

/**
 * 共同的代码
 * @author leoill
 *TODO
 *2019年2月27日
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	/**
	 * 获取验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/vercode")
	public void getVerficationCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int width = 80;
		int height = 32;
		//create the image
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// set the background color
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		// draw the border
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// create a random instance to generate the codes
		Random rdm = new Random();
		String hash1 = Integer.toHexString(rdm.nextInt());
		// make some confusion
		for (int i = 0; i < 50; i++) {
			int x = rdm.nextInt(width);
			int y = rdm.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}
		// generate a random code
		String capstr = hash1.substring(0, 4);
		g.setColor(new Color(0, 100, 0));
		g.setFont(new Font("Candara", Font.BOLD, 24));
		g.drawString(capstr, 8, 24);
		g.dispose();
		response.setContentType("image/jpeg");
		request.getSession().setAttribute("vercode", capstr);
		System.out.println("获取验证码：" + request.getSession().getAttribute("vercode").toString());
		ImageIO.write(image, "JPG", response.getOutputStream());
	}
	/**
	 * 文件上传
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/upload")
	public Map<String, Object> upLoad(@RequestParam(value="file")MultipartFile file ,
			HttpServletRequest request,HttpServletResponse response){
				Map<String, Object> res = new HashMap<>();
				try {
					res = commonService.img(file, request, response);
					return res;
				} catch (Exception e) {
					res.put("errno", "1");
					res.put("msg", e.getMessage());
					res.put("data", new ArrayList<>());
					return res;
				}
	}
}
