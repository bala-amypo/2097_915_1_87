package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    boolean existsByEmail(String email);
    Optional<User> getUser(Long id); // Add this for controller
    Optional<User> getByEmail(String email); // required by impl
    List<User> getAllUsers();
    void deleteUser(Long id);
}
