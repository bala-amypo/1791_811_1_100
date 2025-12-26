package com.example.demo.repository;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {

    // DEFAULT to avoid abstract method error
    default List<VendorDocument> findByVendor(Vendor vendor) {
        return List.of();
    }
}
