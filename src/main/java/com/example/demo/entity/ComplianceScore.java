package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_scores")
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Vendor vendor;

    private Double scoreValue;
    private String rating;
    private LocalDateTime lastEvaluated;

    public ComplianceScore() {}

    public ComplianceScore(Vendor vendor, Double scoreValue, String rating) {
        this.vendor = vendor;
        this.scoreValue = scoreValue;
        this.rating = rating;
    }

    @PrePersist
    @PreUpdate
    void onEvaluate() {
        this.lastEvaluated = LocalDateTime.now();
    }

    // getters & setters
}
