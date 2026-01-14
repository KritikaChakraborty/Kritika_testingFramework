package com.kritika.testingFramework.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class TestSuite {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private List<TestCase> testCases;

    // Returns the number of test cases in this suite
    public int getTestCaseCount() {
        return testCases != null ? testCases.size() : 0;
    }
}
