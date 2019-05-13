package com.bruse.dubbo.controller;

import com.bruse.dubbo.service.IUserService;
import com.bruse.dubbo.service.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Reference
    private IUserService userService;

    @GetMapping
    public Object get() {
        return userService.findAll();
    }

    @PostMapping
    public Object add(User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
