package com.kritika.testingFramework.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestExecutionRun {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private String executedBy; // optional: who triggered the run

    @OneToMany(mappedBy = "testExecutionRun", cascade = CascadeType.ALL)
    private List<TestOutcome> testResults;

    private String analyticsCsvPath; // optional: path to CSV summary for this run

    /**
     * Returns total number of test outcomes in this execution run.
     */
    public int getTotalTests() {
        return testResults != null ? testResults.size() : 0;
    }

    /**
     * Checks if analytics CSV is available for this run.
     */
    public boolean hasAnalyticsCsv() {
        return analyticsCsvPath != null && !analyticsCsvPath.isEmpty();
    }
}
