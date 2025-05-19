package com.project.JobStationApi.repository;

import com.project.JobStationApi.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
