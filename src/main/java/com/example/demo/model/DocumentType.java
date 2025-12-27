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

    private String name;
    private int weight;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "documentType", cascade = CascadeType.ALL)
    private Set<VendorDocument> vendors = new HashSet<>();

    public DocumentType() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Set<VendorDocument> getVendors() { return vendors; }

    @PrePersist
    public void prePersist() { createdAt = LocalDateTime.now(); }
}
