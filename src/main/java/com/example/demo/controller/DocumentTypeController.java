package com.example.demo.controller;

import com.example.demo.entity.DocumentType;
import com.example.demo.service.DocumentTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document-types")
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    // Constructor Injection (Best Practice)
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    // Create a new document type
    @PostMapping
    public ResponseEntity<DocumentType> createDocumentType(
            @RequestBody DocumentType documentType) {

        DocumentType savedType = documentTypeService.createDocumentType(documentType);
        return ResponseEntity.ok(savedType);
    }

    // Get all document types
    @GetMapping
    public ResponseEntity<List<DocumentType>> getAllDocumentTypes() {
        List<DocumentType> documentTypes = documentTypeService.getAllDocumentTypes();
        return ResponseEntity.ok(documentTypes);
    }

    // Get document type by ID
    @GetMapping("/{id}")
    public ResponseEntity<DocumentType> getDocumentTypeById(
            @PathVariable Long id) {

        DocumentType documentType = documentTypeService.getDocumentType(id);
        return ResponseEntity.ok(documentType);
    }
}
