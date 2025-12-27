package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Vendor {
    private Long id;
    private String vendorName;
    private String industry;
    private LocalDateTime createdAt;
    private Set<DocumentType> supportedDocumentTypes = new HashSet<>();

    public Vendor() {}

    public Vendor(Long id, String vendorName, String industry) {
        this.id = id;
        this.vendorName = vendorName;
        this.industry = industry;
        prePersist();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<DocumentType> getSupportedDocumentTypes() {
        return supportedDocumentTypes;
    }

    public void addSupportedDocumentType(DocumentType dt) {
        supportedDocumentTypes.add(dt);
        dt.getVendors().add(this);
    }

    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
