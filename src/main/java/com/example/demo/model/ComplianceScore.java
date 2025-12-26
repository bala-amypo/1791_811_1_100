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

    // 🔹 REQUIRED by ComplianceScoreServiceImpl
    private String rating;

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    // REQUIRED by service
    public Vendor getVendor() {
        return vendor;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    
    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }
}
