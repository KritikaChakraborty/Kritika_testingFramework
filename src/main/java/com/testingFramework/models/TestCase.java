package com.kritika.testingFramework.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // UI or API
    private String type;

    // URL for UI / endpoint for API
    private String target;

    // GET, POST (only for API)
    private String method;

    // Expected result of the test
    private String expectedResult;

    // Actual result after execution
    private String actualResult;

    // PASS / FAIL / SKIPPED
    private String status;

    // Priority: LOW / MEDIUM / HIGH
    private String priority;
}
