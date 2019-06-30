package com.kayleoi.hellospringboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloSpringBootApplicationTests {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate testRestTemplate;//为了是让其能直接访问到controller
    @Before
    public void setUp() throws MalformedURLException {
        this.base=new URL("http://localhost:"+port+"/");
    }
    @Test
    public void contextLoads() {
        ResponseEntity<String> resposeEntity=testRestTemplate.getForEntity(base.toString(),String.class);
        assertThat(resposeEntity.getBody(),equalTo("hello springboot"));

    }

}
