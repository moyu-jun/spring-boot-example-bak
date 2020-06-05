package com.xingtuai.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/6/5
 */
@RestController
@RequestMapping("test")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }
}
