package com.example.demo.service;

import com.example.demo.entity.ComplianceRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ComplianceRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceRuleServiceImpl implements ComplianceRuleService {

    private final ComplianceRuleRepository complianceRuleRepository;

    public ComplianceRuleServiceImpl(ComplianceRuleRepository complianceRuleRepository) {
        this.complianceRuleRepository = complianceRuleRepository;
    }

    @Override
    public ComplianceRule createRule(ComplianceRule rule) {
        if (rule.getRuleName() != null && complianceRuleRepository.findAll().stream()
                .anyMatch(r -> r.getRuleName().equals(rule.getRuleName()))) {
            throw new ValidationException("Duplicate rule name");
        }
        if (rule.getThreshold() < 0) throw new ValidationException("Threshold cannot be negative");
        return complianceRuleRepository.save(rule);
    }

    @Override
    public List<ComplianceRule> getAllRules() {
        return complianceRuleRepository.findAll();
    }

    @Override
    public ComplianceRule getRule(Long id) {
        return complianceRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ComplianceRule not found"));
    }
}
