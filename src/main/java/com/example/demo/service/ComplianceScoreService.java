package com.example.demo.service.impl;

import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final ComplianceScoreRepository repository;

    public ComplianceScoreServiceImpl(ComplianceScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public int getScore(Long vendorId) {
        return repository.findAll()
                .stream()
                .filter(c -> c.getVendor().getId().equals(vendorId))
                .mapToInt(c -> c.getScore())
                .findFirst()
                .orElse(0);
    }
}
