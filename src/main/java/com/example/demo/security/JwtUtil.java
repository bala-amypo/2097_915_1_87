package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET =
            "thisIsASecretKeyForJwtWhichMustBeLongEnough";

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // ===== USED BY CONTROLLERS =====
    public String generateTokenForUser(User user) {
        return generateToken(
                Map.of(
                        "userId", user.getId(),
                        "role", user.getRole()
                ),
                user.getEmail()
        );
    }

    // ===== USED BY TESTS =====
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token);
    }

    // ✅ TESTS EXPECT getPayload()
    public Claims getPayload(String token) {
        return parseToken(token).getBody();
    }

    public String extractUsername(String token) {
        return getPayload(token).getSubject();
    }

    public String extractRole(String token) {
        return getPayload(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return getPayload(token).get("userId", Long.class);
    }

    // ✅ FILTER EXPECTS THIS
    public boolean isTokenValid(String token, String username) {
        try {
            return extractUsername(token).equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}
