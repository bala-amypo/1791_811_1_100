package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    @PostMapping
    public Vendor create(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    @GetMapping("/{id}")
    public Vendor get(@PathVariable Long id) {
        return service.getVendor(id);
    }
}