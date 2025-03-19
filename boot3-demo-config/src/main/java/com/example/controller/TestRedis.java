package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedis {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/redis", method = {RequestMethod.GET, RequestMethod.POST})
    public String createRedis() {
        Long add = stringRedisTemplate.opsForSet().add("sex", "1");
        stringRedisTemplate.opsForValue().set("name", "dog");
        return "createRedis success";
    }
}
