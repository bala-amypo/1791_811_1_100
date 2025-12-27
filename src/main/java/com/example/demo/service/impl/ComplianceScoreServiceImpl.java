package com.example.demo.service.impl;

import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;

    public ComplianceScoreServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void calculateScore() {
        // Example logic
        long count = vendorRepository.count();
        System.out.println("Number of vendors: " + count);
    }
}
