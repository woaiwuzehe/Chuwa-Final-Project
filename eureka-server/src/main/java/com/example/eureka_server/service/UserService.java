package com.example.eureka_server.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 模拟验证用户凭证（真实场景下应使用密码加密和数据库校验）
    public boolean validateUser(String email, String password) {
        // 示例：如果邮箱为 "user@example.com" 且密码为 "password"，则验证通过
        return "user@example.com".equals(email) && "password".equals(password);
    }
}

