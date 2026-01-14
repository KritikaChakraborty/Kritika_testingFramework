package com.kritika.testingFramework.controllers;

import com.kritika.testingFramework.dtos.ExecutionStatusResponse;
import com.kritika.testingFramework.dtos.TestScheduleRequest;
import com.kritika.testingFramework.models.TestExecutionRun;
import com.kritika.testingFramework.service.ExecutionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/execution")
public class ExecutionController {

    private final ExecutionService service;

    public ExecutionController(ExecutionService service) {
        this.service = service;
    }

    @PostMapping("/schedule/run")
    public ExecutionStatusResponse run(@RequestBody TestScheduleRequest request) {
        TestExecutionRun run = service.schedule(request.getTestCaseIds());
        return new ExecutionStatusResponse(run.getId(), run.getStatus());
    }
}
