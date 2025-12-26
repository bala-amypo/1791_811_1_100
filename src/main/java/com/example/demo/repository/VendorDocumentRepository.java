package com.example.demo.repository;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;

import java.util.List;
import java.util.Optional;

public interface VendorDocumentRepository {

    default VendorDocument save(VendorDocument vendorDocument) {
        return vendorDocument;
    }

    default Optional<VendorDocument> findById(Long id) {
        return Optional.empty();
    }

    default List<VendorDocument> findByVendor(Vendor vendor) {
        return List.of();
    }
}
