package com.leo.hotel.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 转换为json
 * @author leoill
 *TODO
 *2018年11月24日
 */
public class JavaToJSon {
	
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
