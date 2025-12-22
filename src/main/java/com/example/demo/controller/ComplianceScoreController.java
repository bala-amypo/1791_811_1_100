package com.example.demo.controller;

import com.example.demo.entity.ComplianceScore;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance-scores")
public class ComplianceScoreController {

    private final ComplianceScoreService complianceScoreService;

    // Constructor Injection (Recommended)
    public ComplianceScoreController(ComplianceScoreService complianceScoreService) {
        this.complianceScoreService = complianceScoreService;
    }

    // Evaluate compliance score for a vendor
    @PostMapping("/evaluate")
    public ResponseEntity<ComplianceScore> evaluateVendor(
            @RequestParam("vendorId") Long vendorId) {

        ComplianceScore score = complianceScoreService.evaluateVendor(vendorId);
        return ResponseEntity.ok(score);
    }

    // Get compliance score for a specific vendor
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<ComplianceScore> getScoreByVendorId(
            @PathVariable Long vendorId) {

        ComplianceScore score = complianceScoreService.getScore(vendorId);
        return ResponseEntity.ok(score);
    }

    // Get all compliance scores
    @GetMapping
    public ResponseEntity<List<ComplianceScore>> getAllScores() {
        List<ComplianceScore> scores = complianceScoreService.getAllScores();
        return ResponseEntity.ok(scores);
    }
}
