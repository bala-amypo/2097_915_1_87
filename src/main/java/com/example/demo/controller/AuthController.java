package com.example.carbonfootprint.controller;

import com.example.carbonfootprint.entity.User;
import com.example.carbonfootprint.security.JwtUtil;
import com.example.carbonfootprint.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User created = userService.createUser(user);
        String token = jwtUtil.generateTokenForUser(created);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        var existingUser = userService.getUserByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            String token = jwtUtil.generateTokenForUser(existingUser.get());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
