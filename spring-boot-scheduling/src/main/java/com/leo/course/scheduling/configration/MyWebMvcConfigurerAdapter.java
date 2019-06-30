package com.leo.course.scheduling.configration;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport{

	private final org.slf4j.Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MyInterception myInterception;
	
	@Autowired
	private UploadConfig uploadConfig;
	
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
			
		registry.addResourceHandler("/**")
         	.addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/img/**").addResourceLocations("file:" + uploadConfig.getPimgPath());
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		logger.info("进入拦截器");
		registry.addInterceptor(myInterception).addPathPatterns("/**");
		
		super.addInterceptors(registry);
	}

	
}
