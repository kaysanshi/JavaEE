package cn.qfengx.portal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.qfengx.portal.intercept.MyInterception;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport  {

	@Autowired
	private MyInterception myInterception;
	
	@Autowired
	private UploadConfig uploadConfig;
	
	 @Override
	    public void addViewControllers( ViewControllerRegistry registry ) {
		 registry.addRedirectViewController( "/" ,"/front/index.html");
	        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
	        super.addViewControllers( registry );
	    } 
	
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
