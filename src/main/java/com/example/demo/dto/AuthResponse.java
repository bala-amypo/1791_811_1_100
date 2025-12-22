package com.example.demo.dto;

public class AuthResponse {
    private Long id;
    private String email;
    private String role;

    public AuthResponse(Long id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }
    // getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
