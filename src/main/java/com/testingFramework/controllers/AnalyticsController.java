package com.kritika.testingFramework.controllers;

import com.kritika.testingFramework.service.AnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    // Controller for fetching analytics like test failure trends
    @GetMapping("/trends")
    public List<Map<String, Object>> trends() {
        return service.failureTrends();
    }
}

