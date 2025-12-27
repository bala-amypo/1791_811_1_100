package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int weight;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "documentType", cascade = CascadeType.ALL)
    private Set<VendorDocument> vendors = new HashSet<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Set<VendorDocument> getVendors() { return vendors; }
    public void setVendors(Set<VendorDocument> vendors) { this.vendors = vendors; }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
