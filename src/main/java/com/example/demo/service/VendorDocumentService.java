package com.example.demo.service;

import com.example.demo.entity.VendorDocument;
import java.util.List;

public interface VendorDocumentService {

    VendorDocument save(VendorDocument doc);
    VendorDocument getById(Long id);
    List<VendorDocument> getAll();
    VendorDocument update(Long id, VendorDocument doc);
    void delete(Long id);
}
