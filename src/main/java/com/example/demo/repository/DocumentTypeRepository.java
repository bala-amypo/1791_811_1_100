package com.example.demo.repository;

import com.example.demo.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    // DEFAULT to avoid abstract method error
    default List<DocumentType> findByRequiredTrue() {
        return List.of();
    }
}
