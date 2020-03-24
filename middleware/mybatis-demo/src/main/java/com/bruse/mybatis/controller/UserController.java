package com.bruse.mybatis.controller;

import com.bruse.mybatis.entity.User;
import com.bruse.mybatis.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("user")
@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("get")
    public Object get() {
        List<User> userList = userRepository.selectUser();
        return userList;
    }

    @GetMapping("getMap")
    public Object getMap() {
        List<Map> userMapList = userRepository.selectUserMap();
        return userMapList;
    }

}
