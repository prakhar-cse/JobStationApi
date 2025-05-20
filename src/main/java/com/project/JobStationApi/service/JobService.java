package com.project.JobStationApi.service;

import com.project.JobStationApi.model.Job;
import com.project.JobStationApi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job addJob(Job job){
        return jobRepository.save(job);
    }

}
