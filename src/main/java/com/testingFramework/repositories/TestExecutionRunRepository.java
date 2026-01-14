package com.kritika.testingFramework.repositories;

import com.kritika.testingFramework.models.TestExecutionRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestExecutionRunRepository extends JpaRepository<TestExecutionRun, Long> {}
