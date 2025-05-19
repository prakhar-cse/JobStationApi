package com.project.JobStationApi.service;

import com.project.JobStationApi.model.Job;
import com.project.JobStationApi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
}
