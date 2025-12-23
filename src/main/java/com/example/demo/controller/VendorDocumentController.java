package com.example.demo.controller;

import com.example.demo.model.VendorDocument;
import com.example.demo.service.VendorDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService service;

    public VendorDocumentController(VendorDocumentService service) {
        this.service = service;
    }

    @PostMapping
    public VendorDocument create(@RequestBody VendorDocument document) {
        return service.createDocument(document);
    }

    @GetMapping("/{id}")
    public VendorDocument getById(@PathVariable Long id) {
        return service.getDocumentById(id);
    }

    @GetMapping
    public List<VendorDocument> getAll() {
        return service.getAllDocuments();
    }

    @PutMapping("/{id}")
    public VendorDocument update(
            @PathVariable Long id,
            @RequestBody VendorDocument document) {
        return service.updateDocument(id, document);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteDocument(id);
        return "Deleted successfully";
    }
}
