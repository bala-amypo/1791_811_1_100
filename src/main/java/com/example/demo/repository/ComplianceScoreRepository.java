package com.example.demo.repository;

import com.example.demo.model.ComplianceScore;
import java.util.Optional;

public interface ComplianceScoreRepository {

    default Optional<ComplianceScore> findByVendor_Id(Long vendorId) {
        return Optional.empty();
    }
}
