package com.example.demo.repository;

import com.example.demo.entity.ComplianceScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplianceScoreRepository extends JpaRepository<ComplianceScore, Long> {
}
