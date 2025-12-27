package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;

    private String industry;

    @ManyToMany
    private Set<DocumentType> supportedDocumentTypes = new HashSet<>();

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Set<DocumentType> getSupportedDocumentTypes() {
        return supportedDocumentTypes;
    }

    public void setSupportedDocumentTypes(Set<DocumentType> supportedDocumentTypes) {
        this.supportedDocumentTypes = supportedDocumentTypes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
