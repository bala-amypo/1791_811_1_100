package com.example.demo.util;

import com.example.demo.model.ComplianceRule;
import com.example.demo.model.DocumentType;

import java.util.List;

public class ComplianceScoringEngine {

    /**
     * Calculate compliance score
     */
    public double calculateScore(List<DocumentType> submittedDocs,
                                 List<ComplianceRule> rules) {

        if (submittedDocs == null || rules == null) {
            return 0.0;
        }

        double score = 0.0;

        for (ComplianceRule rule : rules) {
            if (rule == null) {
                continue;
            }

            for (DocumentType doc : submittedDocs) {
                if (doc != null &&
                    doc.getId().equals(rule.getRequiredDocumentTypeId())) {

                    score += rule.getScore();
                    break;
                }
            }
        }

        return score;
    }

    /**
     * Derive rating from score
     */
    public String deriveRating(double score) {

        if (score >= 80) {
            return "HIGH";
        } else if (score >= 50) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}
