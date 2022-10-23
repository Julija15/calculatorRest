package com.example.calculatorrest.service;

import com.example.calculatorrest.entity.User;
import com.example.calculatorrest.storage.UserStorige;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private UserStorige storage;

    public void save (User user) {
        storage.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return storage.findByUsername(username);
    }
}

