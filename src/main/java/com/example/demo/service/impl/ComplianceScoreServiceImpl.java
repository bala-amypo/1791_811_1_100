package com.example.demo.service.impl;

import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    @Override
    public int calculateScore(Long vendorId) {
        return 100;
    }
}
