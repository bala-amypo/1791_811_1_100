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

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VendorDocument> supportedDocumentTypes = new HashSet<>();

    public Vendor() {}

    // Getter / Setter
    public Long getId() { return id; }
    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Set<VendorDocument> getSupportedDocumentTypes() { return supportedDocumentTypes; }

    // Pre-persist method
    @PrePersist
    public void prePersist() { createdAt = LocalDateTime.now(); }
}
