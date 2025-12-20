package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUser(Long id);  // Fix for getUser(long) error in test
}
