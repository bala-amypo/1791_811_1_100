package com.example.demo.service;

import com.example.demo.model.VendorDocument;

import java.util.List;

public interface VendorDocumentService {
    VendorDocument save(VendorDocument doc);
    VendorDocument getDocument(Long id);
    List<VendorDocument> getAllDocuments();

    // For tests
    VendorDocument uploadDocument(long vendorId, long docTypeId, VendorDocument doc);
}
