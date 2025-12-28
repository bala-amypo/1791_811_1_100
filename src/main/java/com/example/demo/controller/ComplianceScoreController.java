package com.example.demo.controller;

import com.example.demo.model.ComplianceScore;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compliance-scores")
public class ComplianceScoreController {

    private final ComplianceScoreService service;

    public ComplianceScoreController(ComplianceScoreService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{vendorId}")
    public ComplianceScore evaluate(@PathVariable Long vendorId) {
        return service.evaluateVendor(vendorId);
    }

    @GetMapping("/{vendorId}")
    public ComplianceScore getScore(@PathVariable Long vendorId) {
        return service.getScore(vendorId);
    }
}