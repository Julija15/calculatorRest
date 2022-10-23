package com.example.calculatorrest.storage;

import com.example.calculatorrest.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserStorige {
    List<User> getAll();

    Optional<User> findByUsername (String username);


    void save(User user);
}

