package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /**
     * 处理对/hello路径的GET和POST请求。
     *
     * @return 返回字符串 "helloword"。
     */
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST}) // 支持GET和POST请求
    public String getHelloWord() {
        return "helloword";
    }

}
