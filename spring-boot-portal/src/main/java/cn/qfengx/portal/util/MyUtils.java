package cn.qfengx.portal.util;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sun.misc.BASE64Encoder;
	
public class MyUtils {
	
	public static String dataForString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String res = "";
        try {
        	res = sdf.format(date);
        } catch (Exception e) {
        	System.out.println("日期：" + date + "转换格式化：" + pattern + "错误");
        	e.printStackTrace();
        }
        return res;
	}
	
	
	public static String getIP(HttpServletRequest req) {
		String ip = req.getHeader("x - forwarded - for");
        if (ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)){
            ip = req.getHeader("Proxy - Client - IP");
        }

        if (ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)){
            ip = req.getHeader("WL - Proxy - Client - IP");
        }

        if (ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)){
            ip = req.getRemoteAddr();
        }
        return ip;
	}
	
	public static String stringToMD5(String str) {
		String newStr = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (Exception e) {
			System.out.println("MD5加密失败");
			e.printStackTrace();
		}
		return newStr;
	}
	
	public static void ResponseToJson(HttpServletResponse response, Object data) {
    	try {
//	    	Gson gson = new Gson();
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	String jsonStr = objectMapper.writeValueAsString(data);
	    	System.out.println(jsonStr);
	    	response.setContentType("application/json; charset=utf-8");
	    	response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
	     	PrintWriter out = response.getWriter();
	     	out.print(jsonStr);
	     	out.flush();
	    	out.close();
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
