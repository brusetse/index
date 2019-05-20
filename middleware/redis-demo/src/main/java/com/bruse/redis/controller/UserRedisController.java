package com.bruse.redis.controller;

import com.bruse.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRedisController {

    @Autowired
    private RedisTemplate<String, Object> template;

    @PutMapping
    public void set(String key, User user) {
        template.opsForValue().set(key, user);
    }

    @GetMapping
    public Object get(String key) {
        return template.opsForValue().get(key);
    }
}
