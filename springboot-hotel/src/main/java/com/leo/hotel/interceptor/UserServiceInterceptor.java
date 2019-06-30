package com.leo.hotel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * session
 * @author leoi555
 *
 */
@Component
public class UserServiceInterceptor implements HandlerInterceptor{

	/* 
	 * 用于在完成请求和响应后执行操作。
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	/* 
	 * 用于在将响应发送到客户端之前执行操作
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/* 
	 * 在将请求发送到控制器之前执行操作
	 * 返回true之后继续向下执行,返回false之后取消当前请求
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		// TODO Auto-generated method stub
		System.out.println("拦截器："+request.getRequestURI());
//		System.out.println(request.getRequestURI().endsWith(".html"));
		//判断session是否存在
		if(request.getRequestURI().equals("/user/login")){
			return true;
		}
		if (request.getSession().getAttribute("loginUser")!=null) {
			return true;
		}
		if (request.getRequestURI().equals("/pages/index.html")) {
			System.out.println("转发：");
			response.sendRedirect("/pages/login.html");	
			return false;	
		}	
		return true;	
	}
}
