package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String username;
    private String role;
    private String email;

    public AuthResponse(String token, Long userId, String username, String role, String email) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.email = email;
    }

    public String getToken() {
        return token;
    }
}
