package com.example.eureka_server.model;
//请求model，获取用户邮箱和密码
public class AuthRequest {
    private String email;
    private String password;

    // Getter and Setter
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

