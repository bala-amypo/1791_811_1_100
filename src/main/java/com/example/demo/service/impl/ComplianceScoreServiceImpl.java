package com.example.demo.service;

import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorRepository;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;

    public ComplianceScoreServiceImpl(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    /**
     * Checks whether a vendor supports a given document type.
     * Uses ENTITY comparison (not strings).
     */
    public boolean isDocumentSupported(Long vendorId, Long documentTypeId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        DocumentType documentType = documentTypeRepository.findById(documentTypeId)
                .orElseThrow(() -> new IllegalArgumentException("DocumentType not found"));

        return vendor.getSupportedDocumentTypes().contains(documentType);
    }
}
