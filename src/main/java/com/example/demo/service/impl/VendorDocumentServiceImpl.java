package com.example.demo.serviceimpl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository repository;

    public VendorDocumentServiceImpl(VendorDocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public VendorDocument createDocument(VendorDocument document) {
        return repository.save(document);
    }

    @Override
    public VendorDocument getDocumentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
    }

    @Override
    public List<VendorDocument> getAllDocuments() {
        return repository.findAll();
    }

    @Override
    public VendorDocument updateDocument(Long id, VendorDocument document) {
        VendorDocument existing = getDocumentById(id);

        existing.setVendorName(document.getVendorName());
        existing.setDocumentType(document.getDocumentType());
        existing.setExpiryDate(document.getExpiryDate());
        existing.setValid(document.isValid());

        return repository.save(existing);
    }

    @Override
    public void deleteDocument(Long id) {
        repository.deleteById(id);
    }
}
