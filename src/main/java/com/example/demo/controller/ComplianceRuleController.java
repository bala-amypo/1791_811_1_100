package com.example.demo.controller;

import com.example.demo.model.ComplianceRule;
import com.example.demo.service.ComplianceRuleService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/compliance-rules")
public class ComplianceRuleController {

    private final ComplianceRuleService service;

    public ComplianceRuleController(ComplianceRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ComplianceRule save(@RequestBody ComplianceRule rule) {
        return service.save(rule);
    }
}