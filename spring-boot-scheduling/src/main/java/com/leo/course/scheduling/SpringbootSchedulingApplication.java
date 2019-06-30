package com.leo.course.scheduling;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot项目启动类
 *
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.leo.course.scheduling.mapper")
public class SpringbootSchedulingApplication {
	
    public static void main( String[] args ){
       SpringApplication.run(SpringbootSchedulingApplication.class, args);
    }
}
