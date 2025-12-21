package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUser(Long id);

    Optional<User> getByEmail(String email);

    boolean existsByEmail(String email);
}
