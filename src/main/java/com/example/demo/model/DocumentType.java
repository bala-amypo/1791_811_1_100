package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    // REQUIRED by test
    public void setId(Long id) {
        this.id = id;
    }

    // REQUIRED by test
    public String getName() {
        return name;
    }

    // REQUIRED by test
    public void setName(String name) {
        this.name = name;
    }
}
