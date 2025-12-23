package com.example.demo.dto;

public class JwtResponse {

    private String token;
    private String email;
    private String role;

    public JwtResponse() {}

    public JwtResponse(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }

    // getters & setters
}
