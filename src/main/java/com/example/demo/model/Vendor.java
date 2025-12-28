package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String industry;
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "vendor_document_types",
        joinColumns = @JoinColumn(name = "vendor_id"),
        inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private Set<DocumentType> supportedDocumentTypes = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
    
    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public Set<DocumentType> getSupportedDocumentTypes() { return supportedDocumentTypes; }
    public void setSupportedDocumentTypes(Set<DocumentType> supportedDocumentTypes) { 
        this.supportedDocumentTypes = supportedDocumentTypes; 
    }
    
    // Proper equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        
        // If both have IDs, compare by ID
        if (id != null && vendor.id != null) {
            return Objects.equals(id, vendor.id);
        }
        
        // Otherwise, use reference equality for non-persisted objects
        return super.equals(o);
    }
    
    @Override
    public int hashCode() {
        if (id != null) {
            return Objects.hash(id);
        }
        // For non-persisted objects, use identity hash code
        return System.identityHashCode(this);
    }
    
    @Override
    public String toString() {
        return "Vendor{" +
               "id=" + id +
               ", vendorName='" + vendorName + '\'' +
               ", industry='" + industry + '\'' +
               '}';
    }
}