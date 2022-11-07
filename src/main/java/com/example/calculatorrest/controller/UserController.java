package com.example.calculatorrest.controller;

import com.example.calculatorrest.entity.User;
import com.example.calculatorrest.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final List<User> userList;
    @Autowired
    InMemoryUserStorage inMemoryUserStorage;

    public UserController(List<User> userList) {
        this.userList = userList;
    }


    @PostMapping("/save")
    public User save(@RequestBody User user) {
       inMemoryUserStorage.save(user);
        return user;
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userList;
    }
}
