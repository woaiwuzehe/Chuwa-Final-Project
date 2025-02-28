package com.example.eureka_server.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    // 生成密钥（可以写在配置中或使用环境变量）
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token 有效期（例如 1 小时）
    private static final long EXPIRATION_TIME = 3600_000;

    public static String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}

