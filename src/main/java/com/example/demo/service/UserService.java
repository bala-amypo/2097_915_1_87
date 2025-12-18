package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;

public interface UserService {
    User create(User user);
    User get(Long id);
    List<User> getAll();
    User update(Long id, User user);
    void delete(Long id);
}
