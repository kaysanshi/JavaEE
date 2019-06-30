package com.leo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author leoi555
 *
 */
@SpringBootApplication
@EnableCaching//开启使用spring缓存机制的支持
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
