// File: src/main/java/com/example/demo/service/impl/VendorDocumentServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository repository;

    public VendorDocumentServiceImpl(VendorDocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public VendorDocument save(VendorDocument document) {
        return repository.save(document);
    }

    @Override
    public List<VendorDocument> findAll() {
        return repository.findAll();
    }
}
