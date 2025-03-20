package com.example.controller;

import com.example.bean.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SaveUserController {
    private static final Logger logger = LoggerFactory.getLogger(SaveUserController.class);
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/saveUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveUser() {
        logger.info("saveUser....start");
        User user = new User();
        user.setId(String.valueOf(UUID.randomUUID()));
        user.setName("张三");
        user.setSex("男");
        user.setAge("18");
        userRepository.save(user);

        return user.toString();
    }
}
