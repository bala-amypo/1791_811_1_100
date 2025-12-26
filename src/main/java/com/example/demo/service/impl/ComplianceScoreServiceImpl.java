package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.Vendor;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import com.example.demo.util.ComplianceScoringEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private ComplianceScoreRepository scoreRepository;

    private final ComplianceScoringEngine scoringEngine =
            new ComplianceScoringEngine();

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found"));

        double scoreValue = scoringEngine.calculateScore(vendorId);
        String rating = scoringEngine.deriveRating(scoreValue);

        ComplianceScore score = new ComplianceScore();
        score.setVendor(vendor);
        score.setRating(rating);

        return scoreRepository.save(score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {

        return scoreRepository.findAll()
                .stream()
                .filter(s -> s.getVendor() != null &&
                             s.getVendor().getId().equals(vendorId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Compliance score not found"));
    }
}
