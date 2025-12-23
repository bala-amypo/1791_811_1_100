package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_documents")
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;

    /* ===== getters & setters ===== */

    public Long getId() {
        return id;
    }

    // ✅ ADD THIS
    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
}
