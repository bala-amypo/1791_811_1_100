package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class DocumentType {
    private Long id;
    private String name;
    private int weight;
    private LocalDateTime createdAt;
    private Set<Vendor> vendors = new HashSet<>();

    public DocumentType() {}

    public DocumentType(Long id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        prePersist();
    }

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<Vendor> getVendors() {
        return vendors;
    }

    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
        vendor.getSupportedDocumentTypes().add(this);
    }

    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
