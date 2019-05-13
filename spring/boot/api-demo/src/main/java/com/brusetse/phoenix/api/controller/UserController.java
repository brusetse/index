package com.brusetse.phoenix.api.controller;

import com.brusetse.phoenix.api.entity.User;
import com.brusetse.phoenix.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bruce
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Object get() {
        return userRepository.findAll();
    }

    @PostMapping
    public Object add(User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @PutMapping("/{id}")
    public Object updateOne(@PathVariable Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @PatchMapping("/{id}")
    public Object patchOne(@PathVariable Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "delete success";
    }

    @GetMapping("/{id}/cards")
    public Object getOneCards(@PathVariable Long id) {
        return "";
    }

    @DeleteMapping("/{id}/cards/{cardId}")
    public Object deleteOneCards(@PathVariable Long id, @PathVariable Long cardId) {
        return "";
    }

    @GetMapping("/age/{age}")
    public Object get(@PathVariable Integer age) {
        return userRepository.findByAge(age);
    }
}
