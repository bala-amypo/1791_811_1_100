package com.example.demo.serviceimpl;

import com.example.demo.entity.VendorDocument;
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

    public VendorDocument save(VendorDocument doc) {
        return repository.save(doc);
    }

    public VendorDocument getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<VendorDocument> getAll() {
        return repository.findAll();
    }

    public VendorDocument update(Long id, VendorDocument doc) {
        doc.setId(id);
        return repository.save(doc);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
