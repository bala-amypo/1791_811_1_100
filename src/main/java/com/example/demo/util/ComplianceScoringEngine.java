package com.example.demo.util;

import com.example.demo.model.DocumentType;

import java.util.List;

public class ComplianceScoringEngine {

    // ✅ REQUIRED BY TEST
    public double calculateScore(List<DocumentType> required,
                                 List<DocumentType> submitted) {

        if (required == null || submitted == null) {
            return 0.0;
        }

        int matched = 0;

        for (DocumentType r : required) {
            for (DocumentType s : submitted) {
                if (r != null && s != null &&
                    r.getId().equals(s.getId())) {
                    matched++;
                    break;
                }
            }
        }

        return required.isEmpty() ? 0.0 :
                (matched * 100.0) / required.size();
    }

    public String deriveRating(double score) {
        if (score >= 80) return "HIGH";
        if (score >= 50) return "MEDIUM";
        return "LOW";
    }
}
