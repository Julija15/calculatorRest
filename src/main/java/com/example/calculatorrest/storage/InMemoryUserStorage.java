package com.example.calculatorrest.storage;

import com.example.calculatorrest.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryUserStorage implements UserStorige {

    private List<User> users = new ArrayList<>();

    private AtomicLong idGenerator;



    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
    }
}
