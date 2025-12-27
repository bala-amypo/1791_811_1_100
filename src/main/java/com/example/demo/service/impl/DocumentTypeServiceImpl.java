package com.example.demo.service.impl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepository;

    @Autowired
    public VendorDocumentServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
    }

    @Override
    public List<VendorDocument> getAllDocuments() {
        return vendorDocumentRepository.findAll();
    }

    @Override
    public VendorDocument addDocument(VendorDocument document) {
        // Example: Set expiry date 30 days from today
        LocalDate expiry = LocalDate.now().plusDays(30);

        // Convert LocalDate to LocalDateTime (required by VendorDocument)
        document.setExpiryDate(expiry.atStartOfDay());

        // Validate document (example)
        document.setIsValid(checkValidity(document));

        return vendorDocumentRepository.save(document);
    }

    @Override
    public VendorDocument updateDocument(VendorDocument document) {
        // Make sure expiryDate is LocalDateTime
        if (document.getExpiryDate() == null) {
            document.setExpiryDate(LocalDate.now().atStartOfDay());
        }

        document.setIsValid(checkValidity(document));
        return vendorDocumentRepository.save(document);
    }

    private boolean checkValidity(VendorDocument document) {
        // Simple example: document is valid if expiryDate is in future
        LocalDateTime now = LocalDateTime.now();
        return document.getExpiryDate().isAfter(now);
    }
}
