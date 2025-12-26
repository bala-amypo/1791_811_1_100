package com.example.demo.service.impl;

import com.example.demo.model.ComplianceRule;
import com.example.demo.repository.ComplianceRuleRepository;

public class ComplianceRuleServiceImpl {

    private final ComplianceRuleRepository complianceRuleRepository;

    public ComplianceRuleServiceImpl(ComplianceRuleRepository complianceRuleRepository) {
        this.complianceRuleRepository = complianceRuleRepository;
    }

    public ComplianceRule save(ComplianceRule rule) {
        return complianceRuleRepository.save(rule);
    }
}
