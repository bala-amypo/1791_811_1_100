package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "vendor_supported_documents", joinColumns = @JoinColumn(name = "vendor_id"))
    @Column(name = "document_type")
    private List<String> supportedDocumentTypes; // Store as Strings

    public Vendor() {}

    public Vendor(String name, List<String> supportedDocumentTypes) {
        this.name = name;
        this.supportedDocumentTypes = supportedDocumentTypes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSupportedDocumentTypes() {
        return supportedDocumentTypes;
    }

    public void setSupportedDocumentTypes(List<String> supportedDocumentTypes) {
        this.supportedDocumentTypes = supportedDocumentTypes;
    }
}
