package com.kritika.testingFramework.execution;

import com.kritika.testingFramework.models.TestExecutionRun;
import com.kritika.testingFramework.models.TestCase;
import com.kritika.testingFramework.models.TestOutcome;
import com.kritika.testingFramework.repositories.TestOutcomeRepository;
import java.time.LocalDateTime;

public class TestExecutionTask implements Runnable {

    private final TestCase testCase;
    private final TestOutcomeRepository resultRepo;
    private final TestExecutionRun run;

    public TestExecutionTask(
            TestCase testCase,
            TestOutcomeRepository resultRepo,
            TestExecutionRun run
    ) {
        this.testCase = testCase;
        this.resultRepo = resultRepo;
        this.run = run;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        boolean success;

        if ("UI".equalsIgnoreCase(testCase.getType())) {
            success = new SeleniumTestExecutor().run(testCase.getTarget());
        } else {
            success = new ApiTestExecutor().run(
                    testCase.getTarget(),
                    testCase.getMethod()
            );
        }

        long end = System.currentTimeMillis();

        TestOutcome result = new TestOutcome();
        result.setTestCaseId(testCase.getId());
        result.setStatus(success ? "PASS" : "FAIL");
        result.setExecutionTime(end - start);
        result.setExecutedAt(LocalDateTime.now());
        result.setTestExecutionRun(run);

        resultRepo.save(result);
    }
}
