package com.example.demo.util;

import com.example.demo.model.ComplianceRule;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;

import java.util.List;

public class ComplianceScoringEngine {

    public int calculateScore(Vendor vendor, List<ComplianceRule> rules) {

        int score = 0;

        if (vendor == null || rules == null) {
            return score;
        }

        for (ComplianceRule rule : rules) {

            if (rule == null || rule.getDocumentType() == null) {
                continue;
            }

            for (VendorDocument doc : vendor.getDocuments()) {

                if (doc.getDocumentType() != null &&
                    doc.getDocumentType().getId()
                            .equals(rule.getDocumentType().getId()) &&
                    doc.isVerified()) {

                    score += rule.getWeight();
                    break;
                }
            }
        }

        return score;
    }
}
