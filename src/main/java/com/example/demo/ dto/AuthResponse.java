package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private long userId;
    private String username;
    private String email;
    private String role;  // <-- add this
public AuthResponse(String token, long userId, String username, String email) {
    this.token = token;
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.role = "USER"; // default value
}

    // No-args constructor
    public AuthResponse() {}

    // All-args constructor (matches your test)
    public AuthResponse(String token, long userId, String username, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;   // <-- set role
    }

    // Getters
    public String getToken() { return token; }
    public long getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getRole() { return role; }  // <-- getter for role

    // Setters
    public void setToken(String token) { this.token = token; }
    public void setUserId(long userId) { this.userId = userId; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }  // <-- setter for role
}
