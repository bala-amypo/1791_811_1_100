package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.util.ComplianceScoringEngine;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.service.ComplianceScoreService;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService{

    private final VendorRepository vendorRepo;
    private final DocumentTypeRepository docTypeRepo;
    private final VendorDocumentRepository docRepo;
    private final ComplianceScoreRepository scoreRepo;
    private final ComplianceScoringEngine engine = new ComplianceScoringEngine();

    public ComplianceScoreServiceImpl(
            VendorRepository vendorRepo,
            DocumentTypeRepository docTypeRepo,
            VendorDocumentRepository docRepo,
            ComplianceScoreRepository scoreRepo) {
        this.vendorRepo = vendorRepo;
        this.docTypeRepo = docTypeRepo;
        this.docRepo = docRepo;
        this.scoreRepo = scoreRepo;
    }

    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor v = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        List<DocumentType> required = docTypeRepo.findByRequiredTrue();
        List<VendorDocument> docs = docRepo.findByVendor(v);

        double score = engine.calculateScore(
                required,
                docs.stream()
                        .filter(VendorDocument::getIsValid)
                        .map(VendorDocument::getDocumentType)
                        .toList()
        );

        ComplianceScore cs = scoreRepo.findByVendor_Id(vendorId)
                .orElse(new ComplianceScore());

        cs.setVendor(v);
        cs.setScoreValue(score);
        cs.setRating(engine.deriveRating(score));

        return scoreRepo.save(cs);
    }

    public ComplianceScore getScore(Long vendorId) {
        return scoreRepo.findByVendor_Id(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }
}