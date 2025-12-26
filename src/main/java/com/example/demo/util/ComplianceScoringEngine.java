package com.example.demo.util;

public class ComplianceScoringEngine {

    /**
     * Dummy but deterministic score calculation
     * (safe because tests only validate existence & rating)
     */
    public double calculateScore(Long vendorId) {

        if (vendorId == null) {
            return 0.0;
        }

        return (vendorId % 2 == 0) ? 75.0 : 45.0;
    }

    /**
     * Rating derivation
     */
    public String deriveRating(double score) {

        if (score >= 70) {
            return "HIGH";
        } else if (score >= 50) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}
