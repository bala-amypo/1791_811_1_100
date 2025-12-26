package com.example.demo.repository;

import com.example.demo.model.DocumentType;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeRepository {

    default DocumentType save(DocumentType documentType) {
        return documentType;
    }

    default List<DocumentType> findAll() {
        return List.of();
    }

    default List<DocumentType> findByRequiredTrue() {
        return List.of();
    }

    default Optional<DocumentType> findById(Long id) {
        return Optional.empty();
    }
}
