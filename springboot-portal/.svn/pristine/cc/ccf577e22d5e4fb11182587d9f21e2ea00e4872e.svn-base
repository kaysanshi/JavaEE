package cn.qfengx.portal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.qfengx.portal.intercept.MyInterception;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport  {

	@Autowired
	private MyInterception myInterception;
	
	@Autowired
	private UploadConfig uploadConfig;
	
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
			
		registry.addResourceHandler("/**")
         	.addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/pimg/**").addResourceLocations("file:" + uploadConfig.getPimgPath());
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(myInterception).addPathPatterns("/**");
		
		super.addInterceptors(registry);
	}

	
}
