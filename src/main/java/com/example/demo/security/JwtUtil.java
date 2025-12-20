package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "THIS_IS_A_VERY_SECURE_SECRET_KEY_FOR_JWT_256_BITS";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // ================= TOKEN GENERATION =================

    public String generateTokenForUser(User user) {
        return Jwts.builder()
                .setClaims(Map.of(
                        "role", user.getRole(),
                        "userId", user.getId()
                ))
                .setSubject(user.getEmail()) // username = email
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ================= TOKEN EXTRACTION =================

    public String extractUsername(String token) {
        return parseToken(token)
                .getBody()
                .getSubject();
    }

    public String extractRole(String token) {
        return parseToken(token)
                .getBody()
                .get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token)
                .getBody()
                .get("userId", Long.class);
    }

    // ================= TOKEN VALIDATION =================

    public boolean isTokenValid(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    // ================= TOKEN PARSING =================

    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
    }
}
