package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    @ManyToOne
    private Vendor vendor;

    public ComplianceScore() {}

    public ComplianceScore(int score, Vendor vendor) {
        this.score = score;
        this.vendor = vendor;
    }

    public int getScore() {
        return score;
    }

    public Vendor getVendor() {
        return vendor;
    }
}
