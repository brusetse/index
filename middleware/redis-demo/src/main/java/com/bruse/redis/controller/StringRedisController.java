package com.bruse.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringRedisController {

    @Autowired
    private StringRedisTemplate template;

    @PutMapping
    public void set(String key, String value) {
        template.opsForValue().set(key, value);
    }

    @GetMapping
    public Object get(String key) {
        return template.opsForValue().get(key);
    }
}
