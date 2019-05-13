package com.bruse.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${config.env}")
    private String env;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, I'm " + this.env;
    }
}
