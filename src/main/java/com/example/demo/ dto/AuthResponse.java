package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String username;
    private String email;
    private String role;

    // REQUIRED by test
    public AuthResponse(String token, Long userId,
                        String username, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
