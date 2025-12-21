package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET =
            "thisIsASecretKeyForJwtWhichMustBeLongEnough";

    // ================= TOKEN CREATION =================
    public String generateTokenForUser(User user) {
        return generateToken(
                Map.of(
                        "userId", user.getId(),
                        "role", user.getRole()
                ),
                user.getEmail()
        );
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    // ================= TOKEN PARSING =================
    public Jwt<?, Claims> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parse(token);
    }

    // ================= HELPERS (CORRECT FOR 0.9.1) =================
    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    public String extractRole(String token) {
        return parseToken(token).getBody().get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token).getBody().get("userId", Long.class);
    }

    public boolean isTokenValid(String token, String username) {
        try {
            return extractUsername(token).equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}
