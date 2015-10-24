package com.shashwat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.shashwat", "com.shashwat.controller"})
public class SpringBootFirstMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFirstMvcApplication.class, args);
    }
}
