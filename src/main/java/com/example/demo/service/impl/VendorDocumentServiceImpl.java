package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.example.demo.service.VendorDocumentService;
@Service

public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository repo;
    private final VendorRepository vendorRepo;
    private final DocumentTypeRepository docRepo;

    public VendorDocumentServiceImpl(
            VendorDocumentRepository repo,
            VendorRepository vendorRepo,
            DocumentTypeRepository docRepo) {
        this.repo = repo;
        this.vendorRepo = vendorRepo;
        this.docRepo = docRepo;
    }

    public VendorDocument uploadDocument(Long vendorId, Long docTypeId, VendorDocument doc) {
        if (doc.getExpiryDate().isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Expiry date cannot be in the past");

        Vendor v = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        DocumentType dt = docRepo.findById(docTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentType not found"));

        doc.setVendor(v);
        doc.setDocumentType(dt);
        return repo.save(doc);
    }

    public VendorDocument getDocument(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VendorDocument not found"));
    }
}