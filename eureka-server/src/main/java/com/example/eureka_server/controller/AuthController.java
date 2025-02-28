package com.example.eureka_server.controller;

import com.example.eureka_server.model.AuthRequest;
import com.example.eureka_server.model.AuthResponse;
import com.example.eureka_server.service.UserService;
import com.example.eureka_server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        if (userService.validateUser(request.getEmail(), request.getPassword())) {
            String token = JwtUtil.generateToken(request.getEmail());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

