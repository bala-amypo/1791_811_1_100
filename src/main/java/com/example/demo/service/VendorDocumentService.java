// File: src/main/java/com/example/demo/service/VendorDocumentService.java
package com.example.demo.service;

import com.example.demo.model.VendorDocument;

import java.util.List;

public interface VendorDocumentService {
    VendorDocument save(VendorDocument document);
    List<VendorDocument> findAll();
}
