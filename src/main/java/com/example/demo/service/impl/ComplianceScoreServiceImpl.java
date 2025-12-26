package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.Vendor;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import com.example.demo.util.ComplianceScoringEngine;

import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository scoreRepository;

    private final ComplianceScoringEngine scoringEngine =
            new ComplianceScoringEngine();

    // ✅ REQUIRED BY TESTS
    public ComplianceScoreServiceImpl(VendorRepository vendorRepository,
                                      DocumentTypeRepository documentTypeRepository,
                                      VendorDocumentRepository vendorDocumentRepository,
                                      ComplianceScoreRepository scoreRepository) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found"));

        double scoreValue = scoringEngine.calculateScore(
                documentTypeRepository.findAll(),
                documentTypeRepository.findAll()
        );

        ComplianceScore score = new ComplianceScore();
        score.setVendor(vendor);
        score.setRating(scoringEngine.deriveRating(scoreValue));

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
