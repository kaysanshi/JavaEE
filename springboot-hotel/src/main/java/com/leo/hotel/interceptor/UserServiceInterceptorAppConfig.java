package com.leo.hotel.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.leo.hotel.config.UploadConfig;
/**
 * 
 * @author leoi555
 *直接实现WebMvcConfigurer
 *或者实现WebMvcConfigurationSupport
 *注册拦截器
 */
@Configuration
public class UserServiceInterceptorAppConfig extends WebMvcConfigurationSupport{

	@Autowired
	private UserServiceInterceptor userServiceInterceptor;
	@Autowired
	private UploadConfig uploadConfig;
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
			
		registry.addResourceHandler("/**")
         	.addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/imgs/**").addResourceLocations("file:" + uploadConfig.getPimgPath());
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(userServiceInterceptor).addPathPatterns("/**");
		
		super.addInterceptors(registry);
	}
	

}
