package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main2Application {
    public static void main(String[] args) {
        var run = SpringApplication.run(Main2Application.class, args);
        System.out.println("启动成功");
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}