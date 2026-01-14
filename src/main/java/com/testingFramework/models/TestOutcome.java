package com.kritika.testingFramework.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
public class TestOutcome {

    @Id
    @GeneratedValue
    private Long id;

    private Long testCaseId;

    private String status; // PASS / FAIL

    private long executionTime;

    private LocalDateTime executedAt;

    @ManyToOne
    private TestExecutionRun testExecutionRun;
    private int retryCount;      // number of times test was retried
    private boolean isAutomated; // true if test is automated
}
