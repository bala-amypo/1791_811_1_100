package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    private String description;

    public DocumentType() {
    }

    public DocumentType(String typeName, String description) {
        this.typeName = typeName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
