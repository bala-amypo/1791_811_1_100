package com.example.demo.repository;

import com.example.demo.model.ComplianceScore;

import java.util.List;
import java.util.Optional;

public interface ComplianceScoreRepository {

    default ComplianceScore save(ComplianceScore score) {
        return score;
    }

    default Optional<ComplianceScore> findByVendor_Id(Long vendorId) {
        return Optional.empty();
    }

    default List<ComplianceScore> findAll() {
        return List.of();
    }
}
