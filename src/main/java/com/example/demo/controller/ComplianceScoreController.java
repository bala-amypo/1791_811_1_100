package com.example.demo.controller;

import com.example.demo.entity.ComplianceScore;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compliance-scores")
public class ComplianceScoreController {

    private final ComplianceScoreService service;

    public ComplianceScoreController(ComplianceScoreService service) {
        this.service = service;
    }

    @PostMapping
    public ComplianceScore create(@RequestBody ComplianceScore score) {
        return service.save(score);
    }

    @GetMapping
    public List<ComplianceScore> getAll() {
        return service.findAll();
    }
}
