package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;
import com.example.demo.model.*;
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    List<DocumentType> findByRequiredTrue();
}