package com.example.demo.repository;

import com.example.demo.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    // This will return all DocumentType entities where required = true
    List<DocumentType> findByRequiredTrue();
}
