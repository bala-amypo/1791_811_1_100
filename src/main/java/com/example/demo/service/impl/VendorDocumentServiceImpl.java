package com.example.demo.service.impl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.DocumentTypeRepository;

import java.util.HashMap;
import java.util.Map;

public class VendorDocumentServiceImpl {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final Map<Long, VendorDocument> storage = new HashMap<>();

    // Constructor now accepts 3 repositories
    public VendorDocumentServiceImpl(VendorDocumentRepository vendorDocumentRepository,
                                     VendorRepository vendorRepository,
                                     DocumentTypeRepository documentTypeRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    // uploadDocument now returns the uploaded document
    public VendorDocument uploadDocument(long vendorId, long documentTypeId, VendorDocument document) {
        storage.put(documentTypeId, document);
        return document;
    }

    public VendorDocument getDocument(long documentTypeId) {
        return storage.get(documentTypeId);
    }
}
