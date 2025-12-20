package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "secret123";

    // 1️⃣ extractUsername already exists
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // 2️⃣ token validity
    public boolean isTokenValid(String token, String username) {
        final String tokenUsername = extractUsername(token);
        return tokenUsername.equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // 3️⃣ Generate token with extra claims
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 4️⃣ Generate token for user
    public String generateTokenForUser(User user) {
        return generateToken(Map.of("role", user.getRole(), "userId", user.getId()), user.getEmail());
    }

    // 5️⃣ Extract role from token
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // 6️⃣ Extract userId from token
    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    // 7️⃣ Parse token to get Claims
    public Claims parseToken(String token) {
        return extractAllClaims(token);
    }

    // 8️⃣ getPayload (if tests call it)
    public Claims getPayload(String token) {
        return extractAllClaims(token);
    }
    public Claims getPayload(String token) {
    return extractAllClaims(token); // returns Claims object
}

}
