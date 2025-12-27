package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;
    private int weight;

    @ManyToMany
    @JoinTable(
        name = "vendor_document_type",
        joinColumns = @JoinColumn(name = "document_type_id"),
        inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    private Set<Vendor> vendors = new HashSet<>();

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    // 🔴 REQUIRED BY TESTS
    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    // 🔴 REQUIRED BY TESTS
    public int getWeight() {
        return weight;
    }

    // 🔴 REQUIRED BY TESTS
    public void setWeight(int weight) {
        this.weight = weight;
    }

    // 🔴 REQUIRED BY TESTS
    public Set<Vendor> getVendors() {
        return vendors;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
