package cn.qfengx.portal.intercept;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.qfengx.portal.bean.Accesslog;
import cn.qfengx.portal.service.LogService;
import cn.qfengx.portal.util.MyUtils;

@Component
public class MyInterception implements HandlerInterceptor {

	@Autowired
	@Qualifier("LogServiceImpl")
	private LogService logService;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(logService);
		
		System.out.println("拦截器：" + request.getRequestURI());
		//访问记录
		//截取html访问请求
		String loguri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
		if (loguri.endsWith(".html")) {
			Accesslog accesslog = new Accesslog();
			accesslog.setIp(MyUtils.getIP(request));
			accesslog.setTime(new Date());
			accesslog.setUrl(loguri);
			logService.addAccessLog(accesslog);
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
