package com.example.demo.service.impl;

import com.example.demo.util.ComplianceScoringEngine;

public class ComplianceScoreServiceImpl {

    private final ComplianceScoringEngine engine;

    public ComplianceScoreServiceImpl() {
        this.engine = new ComplianceScoringEngine();
    }

    public int getComplianceScore(int value) {
        return engine.calculateScore(value);
    }
}
