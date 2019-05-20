package com.bruse.mongodb.controller;

import com.bruse.mongodb.dao.UserRepository;
import com.bruse.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping
    public Object get() {
        return userRepository.findAll();
    }

    @GetMapping("/findByUsername")
    public Object findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}
