package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    boolean existsByEmail(String email);
}
