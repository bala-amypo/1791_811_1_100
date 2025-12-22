package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.ComplianceScoreService;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable Long id) {
        return vendorService.getVendor(id);
    }

    @GetMapping("/{id}/score")
    public int getComplianceScore(@PathVariable Long id) {
        return complianceScoreService.calculateScore(id);
    }
}
