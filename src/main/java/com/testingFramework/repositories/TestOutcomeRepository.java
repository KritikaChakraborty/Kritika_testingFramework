package com.kritika.testingFramework.repositories;

import com.kritika.testingFramework.models.TestOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestOutcomeRepository extends JpaRepository<TestOutcome, Long> {

    @Query("""
    SELECT CAST(tr.executedAt AS DATE) AS executionDate, COUNT(tr.id) AS failureCount
    FROM TestResult tr
    WHERE tr.status = 'FAIL'
    GROUP BY CAST(tr.executedAt AS DATE)
    """)
    List<Object[]> failureTrends();
}
