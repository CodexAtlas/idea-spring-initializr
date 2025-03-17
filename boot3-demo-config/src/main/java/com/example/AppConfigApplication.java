package com.example;

import com.example.bean.Cat;
import com.example.bean.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppConfigApplication {
    public static void main(String[] args) {
        var ioc = SpringApplication.run(AppConfigApplication.class, args);

        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        String[] dog = ioc.getBeanNamesForType(Dog.class);
        for (String beanName : dog) {
            System.out.println("dog=" + beanName);
        }
        String[] cat = ioc.getBeanNamesForType(Cat.class);
        for (String beanName : cat) {
            System.out.println("cat=" + beanName);
        }
        Dog dog1 = ioc.getBean(Dog.class);
        System.out.println(dog1.getName());

        Object bean1 = ioc.getBean("dog");
        System.out.println(((Dog)bean1).getWeight());

        Object bean = ioc.getBean("str");
        System.out.println(bean);
    }
}