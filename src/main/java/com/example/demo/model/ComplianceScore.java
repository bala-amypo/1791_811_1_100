package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private double score;

    // REQUIRED by test
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    // REQUIRED by test
    public void setScore(double score) {
        this.score = score;
    }

    // REQUIRED by test
    public double getScore() {
        return score;
    }
}
