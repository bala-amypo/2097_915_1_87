package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return service.registerUser(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.getUser(id);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }
}
