package com.example.runStart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello1Controller {
    @RequestMapping(path = "/hello2", method = {RequestMethod.GET, RequestMethod.POST})
    public String getHelloWord() {
        return "Hello World!";
    }
}
