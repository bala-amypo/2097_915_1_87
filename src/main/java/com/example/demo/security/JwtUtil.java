package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "your_secret_key_here";
    private final long EXPIRATION_MS = 1000 * 60 * 60 * 10; // 10 hours

    // Generic token creation
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Generate token for a User object (used in tests)
    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRoles());
        claims.put("userId", user.getId());
        return createToken(claims, user.getEmail());
    }

    // Extract username/email from token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Extract role from token
    public Set<String> extractRole(String token) {
        Object roles = extractAllClaims(token).get("role");
        if (roles instanceof Set) {
            return (Set<String>) roles;
        }
        return Set.of(roles.toString());
    }

    // Extract userId from token
    public Long extractUserId(String token) {
        Object id = extractAllClaims(token).get("userId");
        if (id instanceof Integer) {
            return ((Integer) id).longValue();
        } else if (id instanceof Long) {
            return (Long) id;
        }
        return null;
    }

    // Parse token to User (dummy, used in tests)
    public User parseToken(String token) {
        String email = extractUsername(token);
        Set<String> roles = extractRole(token);
        Long userId = extractUserId(token);
        return new User(userId, "", "", email, "", java.time.LocalDateTime.now());
    }

    // Validate token
    public boolean isTokenValid(String token, String userEmail) {
        final String username = extractUsername(token);
        return (username.equals(userEmail) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
