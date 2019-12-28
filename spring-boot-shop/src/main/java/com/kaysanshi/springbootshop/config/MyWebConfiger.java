package com.kaysanshi.springbootshop.config;

import com.kaysanshi.springbootshop.intercept.MyIntercpetor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/**
 * @Author kay三石
 * @date:2019/11/1
 */
@Configuration
public class MyWebConfiger extends WebMvcConfigurationSupport {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // 设置对“/”的请求重定向到index.html
        //如果没有数据返回到页面，没有必要用控制器方法对请求进行映射
        registry.addRedirectViewController("/", "/front/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 资源处理 添加静态资源处理器 ,自定义静态资源映射目录
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/","resources/");
        // 配置映射资源，访问这个路径直接映射到文件 拦截器
        registry.addResourceHandler("/image/**").addResourceLocations("file:F:/home/ubuntu/upload/shop/");
        super.addResourceHandlers(registry);
    }

    //注册拦截器

    /**
     *  .excludePathPatterns("/static/**");是排除这个路径的拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //SpringMVC下，拦截器的注册需要排除对静态资源的拦截(*.css,*.js)
        //SpringBoot已经做好了静态资源的映射，因此我们无需任何操作 全部拦截除去,但是要排除这个静态中的
        registry.addInterceptor(new MyIntercpetor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
