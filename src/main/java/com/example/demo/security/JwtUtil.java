package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // 24 hours validity
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    // Secure key for HS256
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /* -------------------------------------------------
       TOKEN GENERATION
     ------------------------------------------------- */

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    /* -------------------------------------------------
       TOKEN PARSING
     ------------------------------------------------- */

    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /* -------------------------------------------------
       CLAIM EXTRACTION
     ------------------------------------------------- */

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public Long extractUserId(String token) {
        Object id = parseToken(token).get("userId");
        return id == null ? null : Long.parseLong(id.toString());
    }

    public String extractRole(String token) {
        Object role = parseToken(token).get("role");
        return role == null ? null : role.toString();
    }

    /* -------------------------------------------------
       TOKEN VALIDATION
     ------------------------------------------------- */

    public boolean isTokenValid(String token, String username) {
        try {
            Claims claims = parseToken(token);
            String tokenUsername = claims.getSubject();
            Date expiration = claims.getExpiration();

            return tokenUsername.equals(username)
                    && expiration.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
