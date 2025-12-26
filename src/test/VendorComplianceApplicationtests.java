package com.example.demo;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.Vendor;
import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;
import com.example.demo.model.ComplianceScore;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.service.impl.ComplianceScoreServiceImpl;
import com.example.demo.util.ComplianceScoringEngine;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class VendorComplianceApplicationTests {

    private VendorRepository vendorRepository;
    private DocumentTypeRepository documentTypeRepository;
    private VendorDocumentRepository vendorDocumentRepository;
    private ComplianceScoreRepository scoreRepository;

    private ComplianceScoreServiceImpl complianceScoreService;
    private ComplianceScoringEngine scoringEngine;

    @BeforeClass
    public void setUp() {
        vendorRepository = new VendorRepository() {
        };
        documentTypeRepository = new DocumentTypeRepository() {
        };
        vendorDocumentRepository = new VendorDocumentRepository() {
        };
        scoreRepository = new ComplianceScoreRepository() {
        };

        scoringEngine = new ComplianceScoringEngine();
        complianceScoreService = new ComplianceScoreServiceImpl(
                vendorRepository,
                documentTypeRepository,
                vendorDocumentRepository,
                scoreRepository
        );
    }

    @Test
    public void testAuthResponse() {
        AuthResponse r = new AuthResponse(
                "token123",
                101L,
                "john_doe",
                "john@example.com",
                "ADMIN"
        );

        System.out.println("User ID: " + r.getUserId());
        System.out.println("Email: " + r.getEmail());
        System.out.println("Role: " + r.getRole());
    }

    @Test
    public void testCalculateComplianceScore() {
        Vendor vendor = new Vendor();
        vendor.setId(1L);
        vendor.setName("Vendor One");

        List<DocumentType> submittedDocs = new ArrayList<>();
        DocumentType doc1 = new DocumentType();
        doc1.setId(1L);
        doc1.setName("License");
        submittedDocs.add(doc1);

        List<DocumentType> requiredDocs = new ArrayList<>();
        DocumentType doc2 = new DocumentType();
        doc2.setId(1L);
        doc2.setName("License");
        requiredDocs.add(doc2);

        double scoreValue = scoringEngine.calculateScore(vendor.getId());
        System.out.println("Calculated Score: " + scoreValue);

        ComplianceScore score = new ComplianceScore();
        score.setVendor(vendor);
        score.setScore(scoreValue);

        System.out.println("ComplianceScore for Vendor: " + score.getScore());
    }

    @Test
    public void testVendorDocuments() {
        Vendor vendor = new Vendor();
        vendor.setId(1L);

        List<VendorDocument> documents = new ArrayList<>();
        VendorDocument doc = new VendorDocument();
        doc.setId(1L);
        doc.setVendor(vendor);
        doc.setVerified(true);

        documents.add(doc);

        System.out.println("Vendor Documents: " + documents.size());
        System.out.println("First Document Verified: " + documents.get(0).isVerified());
    }
}
