package com.shashwat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootFirstWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFirstWsApplication.class, args);
    }
    
    @RequestMapping("/")
    public String hello() {
    	return "Hello";
    }
}
