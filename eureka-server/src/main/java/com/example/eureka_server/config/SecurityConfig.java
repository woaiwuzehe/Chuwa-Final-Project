package com.example.eureka_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // 关闭 CSRF，方便调试
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()  // 登录接口允许匿名访问
                        .anyRequest().authenticated()                  // 其它请求需要认证
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // 提供 AuthenticationManager 以便在业务中使用（例如自定义认证逻辑）
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
