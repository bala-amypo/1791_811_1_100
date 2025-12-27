package com.example.demo.repository;

import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {
    // add custom methods if needed
}
