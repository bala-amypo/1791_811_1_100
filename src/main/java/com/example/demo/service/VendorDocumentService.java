package com.example.demo.service;

import com.example.demo.model.VendorDocument;
import java.util.List;

public interface VendorDocumentService {

    VendorDocument createDocument(VendorDocument document);

    VendorDocument getDocumentById(Long id);

    List<VendorDocument> getAllDocuments();

    VendorDocument updateDocument(Long id, VendorDocument document);

    void deleteDocument(Long id);
}
