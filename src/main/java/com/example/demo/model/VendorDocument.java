package com.example.demo.model;

import java.time.LocalDate;

public class VendorDocument {
    private Long id;
    private Vendor vendor;
    private DocumentType documentType;
    private LocalDate expiryDate;
    private boolean isValid;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public DocumentType getDocumentType() { return documentType; }
    public void setDocumentType(DocumentType documentType) { this.documentType = documentType; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public boolean isValid() { return isValid; }
    public void setIsValid(boolean isValid) { this.isValid = isValid; }
}
