package com.example.config;

import com.example.bean.Cat;
import com.example.bean.Dog;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

//@ConditionalOnClass(name="org.h2.jdbc.JdbcBatchUpdateException")// 条件配置类，当类加载时，会判断当前类是否加载，如果加载了，则加载当前类，否则不加载
@SpringBootConfiguration // 配置类, 相当于xml配置文件，用来配置bean，启动时加载
public class AppConfig {
    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setAge(1);
        cat.setColor("white");
        cat.setName("cat");
        return cat;
    }

    @Bean("dog")
    public Dog getDog() {
        Dog dog = new Dog();
        dog.setAge(2);
        dog.setColor("black");
        dog.setName("dog");
        dog.setSex("male");
        dog.setWeight("10kg");
        return dog;
    }
//    @ConditionalOnMissingClass(value = "org.h2.jdbc.JdbcBatchUpdateException")
//    @ConditionalOnMissingBean (name = "dog") // 条件配置类，bean 不存在时，加载当前类，否则不加载
    @ConditionalOnBean(name = "dog")
    @Bean("str")
    public String getString() {
        return "hello";
    }

}
