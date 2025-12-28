package com.example.demo.service.impl;

import com.example.demo.model.DocumentType;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.DocumentTypeService;
import org.springframework.stereotype.Service;

@Service

public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository repository;

    public DocumentTypeServiceImpl(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentType save(DocumentType documentType) {
        return repository.save(documentType);
    }
}