package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public User() {
    }

    public User(Long id, String name, String email, String password,
                String role, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    // getters and setters
}
