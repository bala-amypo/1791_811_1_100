package com.example.demo.service.impl;

import com.example.demo.entity.DocumentType;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.DocumentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository repository;

    public DocumentTypeServiceImpl(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentType createDocumentType(DocumentType documentType) {
        return repository.save(documentType);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return repository.findAll();
    }

    @Override
    public DocumentType getDocumentType(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DocumentType not found"));
    }
}
