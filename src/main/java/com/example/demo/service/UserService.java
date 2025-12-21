package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.Optional;

public interface UserService {
    User getUser(Long id);
    Optional<User> getByEmail(String email);
    User saveUser(User user);
}
