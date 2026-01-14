package com.kritika.testingFramework.export;

import com.kritika.testingFramework.models.TestExecutionRun;
import com.kritika.testingFramework.models.TestOutcome;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class AnalyticsCsvExporter {


    public void exportToCsv(List<TestExecutionRun> runs, PrintWriter writer) {

        // CSV header
        writer.println("RunId,TestCaseId,Status,ExecutionTime,ExecutedAt");

        for (TestExecutionRun run : runs) {
            if (run.getTestResults() != null) {
                for (TestOutcome outcome : run.getTestResults()) {
                    writer.println(
                            run.getId() + "," +
                                    outcome.getTestCaseId() + "," +
                                    outcome.getStatus() + "," +
                                    outcome.getExecutionTime() + "," +
                                    outcome.getExecutedAt()
                    );
                }
            }
        }

        writer.flush(); // ensure all data is written
    }
}


