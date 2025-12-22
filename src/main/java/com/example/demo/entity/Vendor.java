package com.example.demo.controller;

import com.example.demo.entity.Vendor;
import com.example.demo.service.ComplianceScoreService;
import com.example.demo.service.VendorService;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private static final Logger logger = LoggerFactory.getLogger(VendorController.class);

    private final VendorService vendorService;
    private final ComplianceScoreService complianceScoreService;

    public VendorController(VendorService vendorService,
                            ComplianceScoreService complianceScoreService) {
        this.vendorService = vendorService;
        this.complianceScoreService = complianceScoreService;
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        logger.info("Fetching all vendors");
        List<Vendor> vendors = vendorService.getAllVendors();
        if (vendors.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(vendors);
    }

    @GetMapping("/{id}/score")
    public ResponseEntity<Integer> getVendorScore(@PathVariable @Positive Long id) {
        logger.info("Fetching compliance score for vendor ID: {}", id);
        Integer score = complianceScoreService.getScore(id);
        if (score == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(score);
    }
}
