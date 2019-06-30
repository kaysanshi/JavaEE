package com.leo.springboot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot的启动类
 * @author leoi555
 *
 */
@SpringBootApplication//表明这个类是springboot的引导类
public class Application {
	public static void main(String[] args) {
		System.out.println("启动springboot");
		
		SpringApplication.run(Application.class, args);
		//下面启动方式的和上面得一样
//		SpringApplication application=new SpringApplication(Application.class);
//		application.setBannerMode(Mode.OFF);
//		application.run(args);
	}
}
