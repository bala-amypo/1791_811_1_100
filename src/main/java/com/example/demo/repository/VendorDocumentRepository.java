package com.example.demo.repository;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import java.util.List;

public interface VendorDocumentRepository {

    default List<VendorDocument> findByVendor(Vendor vendor) {
        return List.of();
    }
}
