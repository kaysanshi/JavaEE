package com.leo.hotel.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.leo.hotel.utils.MessagesUtils;

/**
 * 验证码
 *短信接口
 * @author leoi555
 *TODO
 *2018年11月22日
 */
@RestController
@RequestMapping("/comm")
public class CommonController {
	/**
	 * 获取验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/vcode")
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
		request.getSession().setAttribute("vcode", capstr);
		System.out.println("获取验证码：" + request.getSession().getAttribute("vcode").toString());
		ImageIO.write(image, "JPG", response.getOutputStream());
	}
	/**
	 * 获取短信验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping("/messagecode")
	public Map<String, Object> getMessageCode(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map=new HashMap<>();
		try {
			String code=UUID.randomUUID().toString().substring(2, 6);
			request.getSession().setAttribute("messagecode", code);
			 System.out.println(code);
			 SendSmsResponse res=MessagesUtils.sendSms(code);
			 System.out.println("短信接口返回的数据----------------");
		        System.out.println("Code=" + res.getCode());
		        System.out.println("Message=" + res.getMessage());
		        System.out.println("RequestId=" + res.getRequestId());
		        System.out.println("BizId=" + res.getBizId());
		        Thread.sleep(3000L);
		        //查明细
		        if(res.getCode() != null && res.getCode().equals("OK")) {
		            QuerySendDetailsResponse querySendDetailsResponse = MessagesUtils.querySendDetails(res.getBizId());
		            System.out.println("短信明细查询接口返回数据----------------");
		            System.out.println("Code=" + querySendDetailsResponse.getCode());
		            System.out.println("Message=" + querySendDetailsResponse.getMessage());
		            map.put("code", "0");
		            map.put("msg", "获取验证码成功");
		            map.put("data", code);
		            System.out.println(code);
		            int i = 0;
		            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
		            {
		                System.out.println("SmsSendDetailDTO["+i+"]:");
		                System.out.println("Content=" + smsSendDetailDTO.getContent());
		                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
		                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
		                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
		                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
		                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
		                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
		                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
		            }
		            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
		            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
		        }else {
		        	map.put("code", "1");
		        	map.put("msg", "获取失败");
		        	map.put("data",null);
		        }
		} catch (ClientException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
		
	}
	/**
	 * 文件的上传
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/upload",method=RequestMethod
			.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	@Deprecated
	public String fileupload(@RequestParam("file") MultipartFile file) throws IOException {
		//设置文件上传的路径
		File converFile=new File("/var/tmp/"+file.getOriginalFilename());
		converFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(converFile);
	    fout.write(file.getBytes());
	    fout.close();
		return "file is upload successfully";
		
	}
	/**
	 *文件下载
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET) 
	@Deprecated
	public ResponseEntity<Object> downloadFile() throws IOException  {
	      String filename = "/var/tmp/mysql.png";
	      File file = new File(filename);
	      InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	      HttpHeaders headers = new HttpHeaders();

	      headers.add("Content-Disposition", String.format("attachment; filename=\\'%s\\'", file.getName()));
	      headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	      headers.add("Pragma", "no-cache");
	      headers.add("Expires", "0");

	      ResponseEntity<Object> 
	      responseEntity = ResponseEntity.ok().headers(headers).contentLength(
	         file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);

	      return responseEntity;
	   }
}
