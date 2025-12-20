package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully!";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @GetMapping("/{id}")
public ResponseEntity<String> getUserName(@PathVariable Long id) {
    return userService.getUser(id)
            .map(user -> ResponseEntity.ok(user.getFullName()))
            .orElse(ResponseEntity.notFound().build());
}

}
