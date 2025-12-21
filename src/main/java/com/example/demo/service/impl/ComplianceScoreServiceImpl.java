package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.*;
import com.example.demo.util.ComplianceScoringEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository complianceScoreRepository;
    private final ComplianceScoringEngine scoringEngine;

    public ComplianceScoreServiceImpl(VendorRepository vendorRepository,
                                      DocumentTypeRepository documentTypeRepository,
                                      VendorDocumentRepository vendorDocumentRepository,
                                      ComplianceScoreRepository complianceScoreRepository,
                                      ComplianceScoringEngine scoringEngine) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceScoreRepository = complianceScoreRepository;
        this.scoringEngine = scoringEngine;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        List<DocumentType> requiredTypes = documentTypeRepository.findByRequiredTrue();
        List<VendorDocument> vendorDocs = vendorDocumentRepository.findByVendor(vendor);

        double scoreValue = scoringEngine.calculateScore(vendor, requiredTypes, vendorDocs);
        if (scoreValue < 0) throw new ValidationException("Compliance score cannot be negative");

        String rating = scoringEngine.deriveRating(scoreValue);

        ComplianceScore score = complianceScoreRepository.findByVendorId(vendorId)
                .orElse(new ComplianceScore(vendor, scoreValue, rating));

        score.setScoreValue(scoreValue);
        score.setRating(rating);

        return complianceScoreRepository.save(score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendorId(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("ComplianceScore not found"));
    }

    @Override
    public List<ComplianceScore> getAllScores() {
        return complianceScoreRepository.findAll();
    }
}
