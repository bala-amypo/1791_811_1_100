package com.example.demo.controller;

import com.example.demo.service.ComplianceScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

    private final ComplianceScoreService complianceScoreService;

    public VendorController(ComplianceScoreService complianceScoreService) {
        this.complianceScoreService = complianceScoreService;
    }

    @GetMapping("/compliance-score")
    public String getScore(@RequestParam Long vendorId) {
        int score = complianceScoreService.calculateScore(vendorId);
        return "Compliance Score = " + score;
    }
}
