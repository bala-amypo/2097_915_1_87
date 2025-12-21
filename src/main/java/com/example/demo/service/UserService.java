package com.example.carbonfootprint.service;

import com.example.carbonfootprint.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUser(Long id);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
}
