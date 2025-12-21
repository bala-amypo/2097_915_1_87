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
            "THIS_IS_A_VERY_SECURE_SECRET_KEY_FOR_JWT_256_BITS_LONG";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    /* ========================= TOKEN GENERATION ========================= */

    // Used by AuthController
    public String generateTokenForUser(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Used by Test cases
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /* ========================= TOKEN PARSING ========================= */

    // REQUIRED BY TEST CASES
    public ParsedToken parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return new ParsedToken(claims);
    }

    /* ========================= VALIDATION ========================= */

    // Used by Filter
    public boolean isTokenValid(String token, String username) {
        try {
            String extractedUsername = extractUsername(token);
            return extractedUsername.equals(username) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    // Used by Tests
    public boolean isTokenValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    /* ========================= CLAIM EXTRACTION ========================= */

    // Used by Filter
    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    // Used by Tests
    public String extractRole(String token) {
        Object role = parseToken(token).getPayload().get("role");
        return role != null ? role.toString() : null;
    }

    // Used by Tests
    public Long extractUserId(String token) {
        Object id = parseToken(token).getPayload().get("userId");
        return id != null ? Long.parseLong(id.toString()) : null;
    }

    private boolean isTokenExpired(String token) {
        Date expiration = parseToken(token).getPayload().getExpiration();
        return expiration.before(new Date());
    }

    /* ========================= INNER CLASS (NO EXTRA FILE) ========================= */

    // Allows: jwtUtil.parseToken(token).getPayload()
    public static class ParsedToken {
        private final Claims claims;

        public ParsedToken(Claims claims) {
            this.claims = claims;
        }

        public Claims getPayload() {
            return claims;
        }
    }
}
