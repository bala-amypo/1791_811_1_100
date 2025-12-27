package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;

    private LocalDateTime uploadedAt;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DocumentType documentType;

    // Constructors
    public VendorDocument() {}
    
    public VendorDocument(Vendor vendor, DocumentType documentType, String fileUrl) {
        this.vendor = vendor;
        this.documentType = documentType;
        this.fileUrl = fileUrl;
        this.uploadedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void prePersist() { this.uploadedAt = LocalDateTime.now(); }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public DocumentType getDocumentType() { return documentType; }
    public void setDocumentType(DocumentType documentType) { this.documentType = documentType; }
}
