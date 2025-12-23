package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dummy AuthController
 * Security is intentionally disabled for CRUD-only implementation
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/status")
    public String status() {
        return "Auth module disabled";
    }
}
