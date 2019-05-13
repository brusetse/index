package com.bruse.dubbo;

import com.bruse.dubbo.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
@ComponentScan({"com.bruse.dubbo.controller"})
public class ConsumerApplication {

    @Reference
    private IUserService userService;

    @GetMapping("/echo")
    public Object get() {
        return userService.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
