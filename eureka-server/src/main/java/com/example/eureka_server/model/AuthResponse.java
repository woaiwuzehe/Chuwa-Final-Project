package com.example.eureka_server.model;
//响应model，获取jwt token
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }
}

