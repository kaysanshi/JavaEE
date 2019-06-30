package cn.qfengx.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("cn.qfengx.portal.mapper")
@ServletComponentScan
public class SpringBootPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPortalApplication.class, args);
	}
}
