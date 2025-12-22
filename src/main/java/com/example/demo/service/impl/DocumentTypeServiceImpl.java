package com.example.demo.service.impl;

import com.example.demo.entity.DocumentType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.DocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;

    @Override
    public DocumentType createDocumentType(DocumentType type) {
        documentTypeRepository.findByTypeName(type.getTypeName())
                .ifPresent(t -> {
                    throw new RuntimeException("Document type already exists");
                });
        return documentTypeRepository.save(type);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeRepository.findAll();
    }

    @Override
    public DocumentType getDocumentType(Long id) {
        return documentTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentType not found"));
    }
}
