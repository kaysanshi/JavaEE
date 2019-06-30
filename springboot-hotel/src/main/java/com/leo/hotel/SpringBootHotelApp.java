package com.leo.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/**
 * 
 * @author leoi555
 *TODO
 *2018年11月22日
 */
@SpringBootApplication
@MapperScan("com.leo.hotel.mapper")
@ServletComponentScan//扫描servlet
public class SpringBootHotelApp {
    public static void main(String[] args){
    	SpringApplication.run(SpringBootHotelApp.class, args);
    }
}
