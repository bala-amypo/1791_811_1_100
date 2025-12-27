package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository documentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository typeRepository;

    public VendorDocumentServiceImpl(VendorDocumentRepository documentRepository,
                                     VendorRepository vendorRepository,
                                     DocumentTypeRepository typeRepository) {
        this.documentRepository = documentRepository;
        this.vendorRepository = vendorRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public VendorDocument save(VendorDocument doc) {
        doc.prePersist();
        return documentRepository.save(doc);
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @Override
    public List<VendorDocument> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public VendorDocument uploadDocument(long vendorId, long typeId, VendorDocument doc) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
        DocumentType type = typeRepository.findById(typeId).orElseThrow();
        doc.setVendor(vendor);
        doc.setDocumentType(type);
        doc.prePersist();
        return documentRepository.save(doc);
    }
}
