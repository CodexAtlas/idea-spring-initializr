package com.example.testport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        var run = SpringApplication.run(MainApplication.class, args);
        System.out.println("启动成功");
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}