package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vendorName;

    private String email;
    private String phone;
    private String industry;

    private LocalDateTime createdAt;

    public Vendor() {}

    public Vendor(String vendorName, String email, String phone, String industry) {
        this.vendorName = vendorName;
        this.email = email;
        this.phone = phone;
        this.industry = industry;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() { return id; }

    public String getVendorName() { return vendorName; }

    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getIndustry() { return industry; }

    public void setIndustry(String industry) { this.industry = industry; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
