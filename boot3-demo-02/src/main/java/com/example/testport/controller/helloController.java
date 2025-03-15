package com.example.testport.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @RequestMapping(path = "/hello1", method = {RequestMethod.GET, RequestMethod.POST})
    public String getHelloWord() {
        return "Hello World!";
    }
}
