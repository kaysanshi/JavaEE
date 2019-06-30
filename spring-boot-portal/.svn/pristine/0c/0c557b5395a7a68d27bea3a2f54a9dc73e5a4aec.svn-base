package cn.qfengx.portal.controller;

import java.awt.Color;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.qfengx.portal.service.CommonService;

/**
 * 公共接口类
 * 		图片上传
 * 		验证码
 * <p>Title: CommonController</p>
 * <p>Description: </p>
 * <p>Domain: qfengx.cn</p>
 * @author Qfeng
 * @date 2018年11月15日 下午9:00:42
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	@Qualifier("CommonServiceImpl")
	private CommonService commonService;
	
	/**
	 * 上传图片
	 * @param file
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/img")
	@ResponseBody
	public Map<String, Object> img(@RequestParam("file") MultipartFile file,
			HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> res = new HashMap<>();
		try {
			res = commonService.img(file, req, resp);
			return res;
		} catch (Exception e) {
			res.put("errno", "1");
			res.put("msg", e.getMessage());
			res.put("data", new ArrayList<>());
			return res;
		}
	}
	
	/**
	 * 获取验证码
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@GetMapping("/vercode")
	public void vercode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c = new Color(200, 150, 255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);
		char[] ch = "123456789".toCharArray();
		Random r = new Random();
		int index, len = ch.length;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.drawString(ch[index] + "", (i * 15) + 3, 18);
			sb.append(ch[index]);
		}
		req.getSession().setAttribute("vercode", sb.toString());
		System.out.println("获取验证码：" + req.getSession().getAttribute("vercode").toString());
		ImageIO.write(bi, "JPG", resp.getOutputStream());
	}
}
