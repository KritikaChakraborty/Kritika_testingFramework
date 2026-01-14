package com.kritika.testingFramework.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TestScheduleRequest {
    private List<Long> testCaseIds;
    private String scheduleName;             //  name of the schedule
}
