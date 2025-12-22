package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.ComplianceScoreService;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;
    private final ComplianceScoreService complianceScoreService;

    public VendorController(VendorService vendorService,
                            ComplianceScoreService complianceScoreService) {
        this.vendorService = vendorService;
        this.complianceScoreService = complianceScoreService;
    }

    @GetMapping
    public List<Vendor> getVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}/score")
    public int getScore(@PathVariable Long id) {
        return complianceScoreService.calculateScore(id);
    }
}
