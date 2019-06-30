package com.kaysanshi.institute;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.kaysanshi.institute.mapper")
@ServletComponentScan
public class SpringBootInstituteApplication {

	public static void main(String[] args) {
		SpringApplication.run( SpringBootInstituteApplication.class, args);
	}
}
