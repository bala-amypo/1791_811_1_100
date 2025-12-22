package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String description;

    public ComplianceRule() {}

    public ComplianceRule(String ruleName, String description) {
        this.ruleName = ruleName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getDescription() {
        return description;
    }
}
