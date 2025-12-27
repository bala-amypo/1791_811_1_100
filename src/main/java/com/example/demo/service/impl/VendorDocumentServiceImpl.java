package com.example.demo.service.impl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;

import java.util.HashMap;
import java.util.Map;

public class VendorDocumentServiceImpl {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final Map<Long, VendorDocument> storage = new HashMap<>();

    public VendorDocumentServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
    }

    public void uploadDocument(long vendorId, long documentTypeId, VendorDocument document) {
        storage.put(documentTypeId, document);
    }

    public VendorDocument getDocument(long documentTypeId) {
        return storage.get(documentTypeId);
    }
}
