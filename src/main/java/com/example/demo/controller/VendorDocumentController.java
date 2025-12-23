package com.example.demo.controller;

import com.example.demo.entity.VendorDocument;
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
    public VendorDocument create(@RequestBody VendorDocument doc) {
        return service.save(doc);
    }

    @GetMapping("/{id}")
    public VendorDocument get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VendorDocument> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public VendorDocument update(@PathVariable Long id,
                                 @RequestBody VendorDocument doc) {
        return service.update(id, doc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
