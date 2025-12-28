package com.example.demo.util;

import com.example.demo.model.DocumentType;
import java.util.List;

public class ComplianceScoringEngine {

    public double calculateScore(List<DocumentType> required, List<DocumentType> submitted) {
        if (required.isEmpty()) return 100.0;

        int total = required.stream().mapToInt(DocumentType::getWeight).sum();
        int achieved = required.stream()
                .filter(submitted::contains)
                .mapToInt(DocumentType::getWeight)
                .sum();

        return (achieved * 100.0) / total;
    }

    public String deriveRating(double score) {
        if (score >= 90) return "EXCELLENT";
        if (score >= 75) return "GOOD";
        if (score >= 50) return "POOR";
        return "NON_COMPLIANT";
    }
}
\