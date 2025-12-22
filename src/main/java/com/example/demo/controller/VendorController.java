package com.example.demo.controller;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    // Constructor Injection (Recommended)
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // Create a new vendor
    @PostMapping
    public ResponseEntity<Vendor> createVendor(
            @RequestBody Vendor vendor) {

        Vendor savedVendor = vendorService.createVendor(vendor);
        return ResponseEntity.ok(savedVendor);
    }

    // Get all vendors
    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok(vendors);
    }

    // Get vendor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(
            @PathVariable Long id) {

        Vendor vendor = vendorService.getVendor(id);
        return ResponseEntity.ok(vendor);
    }
}
