package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceScore;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final ComplianceScoreRepository repository;

    public ComplianceScoreServiceImpl(ComplianceScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public ComplianceScore save(ComplianceScore score) {
        return repository.save(score);
    }

    @Override
    public List<ComplianceScore> findAll() {
        return repository.findAll();
    }
}
