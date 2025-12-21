package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.*;

public class JwtUtil {

    private static final String SECRET =
            "thisIsASecretKeyForJwtWhichMustBeLongEnough";

    private Key key() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 3600000))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Jwt<?> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parse(token);
    }

    public String extractUsername(String token) {
        return ((Claims) parseToken(token).getBody()).getSubject();
    }
}
