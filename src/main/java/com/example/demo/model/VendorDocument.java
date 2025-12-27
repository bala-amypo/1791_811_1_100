package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "vendor_document_types",
        joinColumns = @JoinColumn(name = "vendor_id"),
        inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private List<DocumentType> supportedDocumentTypes = new ArrayList<>();

    // Constructors
    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DocumentType> getSupportedDocumentTypes() {
        return supportedDocumentTypes;
    }

    public void setSupportedDocumentTypes(List<DocumentType> supportedDocumentTypes) {
        this.supportedDocumentTypes = supportedDocumentTypes;
    }
}
