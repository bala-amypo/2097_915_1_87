package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "carbonfootprintcarbonfootprintcarbonfootprintcarbonfootprint";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    private final Key key;

    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /* =========================================================
       TOKEN GENERATION
       ========================================================= */

    public String generateTokenForUser(User user) {
        return generateToken(
                Map.of(
                        "userId", user.getId(),
                        "role", user.getRole(),
                        "email", user.getEmail()
                ),
                user.getEmail()
        );
    }

    // REQUIRED BY TESTS
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /* =========================================================
       TOKEN PARSING  (TEST-COMPATIBLE)
       ========================================================= */

    // IMPORTANT: Return custom wrapper
    public JwtParseResult parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return new JwtParseResult(claims);
    }

    /* =========================================================
       CLAIM EXTRACTION
       ========================================================= */

    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    // REQUIRED BY TESTS
    public String extractRole(String token) {
        Object role = parseToken(token).getPayload().get("role");
        return role != null ? role.toString() : null;
    }

    // REQUIRED BY TESTS
    public Long extractUserId(String token) {
        Object userId = parseToken(token).getPayload().get("userId");
        if (userId instanceof Integer) {
            return ((Integer) userId).longValue();
        }
        return userId != null ? (Long) userId : null;
    }

    /* =========================================================
       TOKEN VALIDATION
       ========================================================= */

    public boolean isTokenValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isTokenValid(String token, String username) {
        try {
            Claims claims = parseToken(token).getPayload();
            return claims.getSubject().equals(username)
                    && claims.getExpiration().after(new Date());
        } catch (Exception ex) {
            return false;
        }
    }
}
