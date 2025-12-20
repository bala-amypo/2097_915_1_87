package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User getUser(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
