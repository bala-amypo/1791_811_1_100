package com.example.demo.controller;

import com.example.demo.model.DocumentType;
import com.example.demo.service.DocumentTypeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document-types")
public class DocumentTypeController {

    private final DocumentTypeService service;

    public DocumentTypeController(DocumentTypeService service) {
        this.service = service;
    }

    @PostMapping
    public DocumentType save(@RequestBody DocumentType documentType) {
        return service.save(documentType);
    }
}