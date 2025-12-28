package com.example.demo.controller;

import com.example.demo.model.VendorDocument;
import com.example.demo.service.VendorDocumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService service;

    public VendorDocumentController(VendorDocumentService service) {
        this.service = service;
    }

    @PostMapping("/upload/{vendorId}/{documentTypeId}")
    public VendorDocument upload(
            @PathVariable Long vendorId,
            @PathVariable Long documentTypeId,
            @RequestBody VendorDocument document) {

        return service.uploadDocument(vendorId, documentTypeId, document);
    }

    @GetMapping("/{id}")
    public VendorDocument get(@PathVariable Long id) {
        return service.getDocument(id);
    }
}