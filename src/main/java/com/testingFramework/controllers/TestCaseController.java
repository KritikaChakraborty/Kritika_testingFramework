package com.kritika.testingFramework.controllers;

import com.kritika.testingFramework.models.TestCase;
import com.kritika.testingFramework.service.TestCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService service;

    public TestCaseController(TestCaseService service) {
        this.service = service;
    }

    @PostMapping
    public TestCase create(@RequestBody TestCase tc) {
        return service.save(tc);
    }

    @GetMapping
    public List<TestCase> getAll() {
        return service.findAll();
    }
}
