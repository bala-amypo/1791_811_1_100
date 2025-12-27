package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VendorDocument {
    private Long id;
    private String fileUrl;
    private LocalDate expiryDate;
    private LocalDateTime uploadedAt;
    private Vendor vendor;
    private DocumentType documentType;

    public VendorDocument() {}

    public VendorDocument(Vendor vendor, DocumentType documentType) {
        this.vendor = vendor;
        this.documentType = documentType;
        prePersist();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void prePersist() {
        if (uploadedAt == null) {
            uploadedAt = LocalDateTime.now();
        }
    }
}
