package com.example.demo.service;

import com.example.demo.entity.ComplianceScore;
import java.util.List;

public interface ComplianceScoreService {

    ComplianceScore save(ComplianceScore score);

    List<ComplianceScore> findAll();
}
