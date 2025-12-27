package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;
    private LocalDateTime uploadedAt;
    private LocalDate expiryDate; // add expiryDate

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DocumentType documentType;

    public VendorDocument() {}

    public VendorDocument(Vendor vendor, DocumentType type, String fileUrl, LocalDate expiryDate) {
        this.vendor = vendor;
        this.documentType = type;
        this.fileUrl = fileUrl;
        this.expiryDate = expiryDate;
        this.uploadedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void prePersist() { this.uploadedAt = LocalDateTime.now(); }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public DocumentType getDocumentType() { return documentType; }
    public void setDocumentType(DocumentType type) { this.documentType = type; }
}
