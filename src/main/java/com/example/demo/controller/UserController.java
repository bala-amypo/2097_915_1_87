package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity; // Add this import

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserName(@PathVariable Long id) {
        return userService.getUser(id)
                .map(user -> ResponseEntity.ok(user.getFullName()))
                .orElse(ResponseEntity.notFound().build());
    }
}
