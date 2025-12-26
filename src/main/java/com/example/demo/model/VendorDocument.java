package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DocumentType documentType;

    private boolean verified;

    private boolean isValid;

    private LocalDate expiryDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    // REQUIRED by VendorDocumentServiceImpl
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // REQUIRED by VendorDocumentServiceImpl
    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    // REQUIRED by VendorDocumentServiceImpl
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    // REQUIRED by test
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    // REQUIRED by test
    public boolean isVerified() {
        return verified;
    }
}
