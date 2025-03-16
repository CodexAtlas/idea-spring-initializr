package com.example;

import com.example.accessingdatajpa.Customer;
import com.example.accessingdatajpa.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
    public static void main(String[] args) {
        var ioc = SpringApplication.run(AccessingDataJpaApplication.class, args);
        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
    @Bean
    CommandLineRunner runner(CustomerRepository repository) {
        return args -> {
            repository.save(new com.example.accessingdatajpa.Customer("Jack", "Bauer"));
            repository.save(new com.example.accessingdatajpa.Customer("Chloe", "O'Brian"));
            repository.save(new com.example.accessingdatajpa.Customer("Kim", "Bauer"));
            log.info("Customers found with findAll():");
            log.info("--------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");



        };
    }
}