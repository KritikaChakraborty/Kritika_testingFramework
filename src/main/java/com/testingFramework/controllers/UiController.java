package com.kritika.testingFramework.controllers;

import com.kritika.testingFramework.export.AnalyticsCsvExporter;
import com.kritika.testingFramework.models.TestCase;
import com.kritika.testingFramework.models.TestExecutionRun;
import com.kritika.testingFramework.repositories.TestExecutionRunRepository;
import com.kritika.testingFramework.repositories.TestOutcomeRepository;
import com.kritika.testingFramework.service.TestCaseService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/ui")
public class UiController {

    private final TestCaseService testCaseService;
    private final TestOutcomeRepository resultRepo;
    private final TestExecutionRunRepository testExecutionRunRepository;
    private final AnalyticsCsvExporter csvExporter;

    public UiController(
            TestCaseService testCaseService,
            TestOutcomeRepository resultRepo,
            TestExecutionRunRepository testExecutionRunRepository,
            AnalyticsCsvExporter csvExporter
    ) {
        this.testCaseService = testCaseService;
        this.resultRepo = resultRepo;
        this.testExecutionRunRepository = testExecutionRunRepository;
        this.csvExporter = csvExporter;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("testCases", testCaseService.findAll());
        model.addAttribute("testCase", new TestCase());
        return "dashboard";
    }

    @PostMapping("/testcase")
    public String createTestCase(@ModelAttribute TestCase testCase) {
        testCaseService.save(testCase);
        return "redirect:/ui/dashboard";
    }

    @PostMapping("/run")
    public String runTests(@RequestParam List<Long> testCaseIds) {
        // Add your test execution logic here if needed
        return "redirect:/ui/execution";
    }

    @GetMapping("/execution")
    public String execution(Model model) {
        model.addAttribute("results", resultRepo.findAll());
        return "execution";
    }

    @GetMapping("/analytics")
    public String analytics(Model model) {
        List<TestExecutionRun> runs = testExecutionRunRepository.findAll();
        model.addAttribute("trends", runs);
        return "analytics";
    }

    @GetMapping("/export/csv")
    public void exportCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=analytics.csv");

        List<TestExecutionRun> runs = testExecutionRunRepository.findAll();
        csvExporter.exportToCsv(runs, response.getWriter());
    }
}

