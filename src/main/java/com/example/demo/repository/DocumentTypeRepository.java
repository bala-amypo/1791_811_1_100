package com.example.demo.repository;

import com.example.demo.model.DocumentType;
import java.util.List;

public interface DocumentTypeRepository {

    default List<DocumentType> findByRequiredTrue() {
        return List.of();
    }
}
