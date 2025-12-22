package com.example.demo.controller;

import com.example.demo.entity.VendorDocument;
import com.example.demo.service.VendorDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService vendorDocumentService;

    // Constructor Injection (Best Practice)
    public VendorDocumentController(VendorDocumentService vendorDocumentService) {
        this.vendorDocumentService = vendorDocumentService;
    }

    // Upload a document for a vendor
    @PostMapping("/upload")
    public ResponseEntity<VendorDocument> uploadDocument(
            @RequestParam("vendorId") Long vendorId,
            @RequestParam("typeId") Long typeId,
            @RequestBody VendorDocument document) {

        VendorDocument savedDocument =
                vendorDocumentService.uploadDocument(vendorId, typeId, document);

        return ResponseEntity.ok(savedDocument);
    }

    // Get all documents for a vendor
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorDocument>> getDocumentsByVendorId(
            @PathVariable Long vendorId) {

        List<VendorDocument> documents =
                vendorDocumentService.getDocumentsForVendor(vendorId);

        return ResponseEntity.ok(documents);
    }

    // Get a document by ID
    @GetMapping("/{id}")
    public ResponseEntity<VendorDocument> getDocumentById(
            @PathVariable Long id) {

        VendorDocument document = vendorDocumentService.getDocument(id);
        return ResponseEntity.ok(document);
